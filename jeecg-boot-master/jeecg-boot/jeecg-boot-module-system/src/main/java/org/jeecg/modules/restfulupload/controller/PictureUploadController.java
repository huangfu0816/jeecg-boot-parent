package org.jeecg.modules.restfulupload.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.restfulupload.entity.PictureUpload;
import org.jeecg.modules.restfulupload.service.IPictureUploadService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
* @Description: 图片上传
* @Author: jeecg-boot
* @Date:   2020-05-06
* @Version: V1.0
*/
@Api(tags="图片上传")
@RestController
@RequestMapping("/com.ynyxsoft.lawcase/pictureUpload")
@Slf4j
public class PictureUploadController extends JeecgController<PictureUpload, IPictureUploadService> {
   @Autowired
   private IPictureUploadService pictureUploadService;

   /**
    * 分页列表查询
    *
    * @param pictureUpload
    * @param pageNo
    * @param pageSize
    * @param req
    * @return
    */
   @AutoLog(value = "图片上传-分页列表查询")
   @ApiOperation(value="图片上传-分页列表查询", notes="图片上传-分页列表查询")
   @GetMapping(value = "/list")
   public Result<?> queryPageList(PictureUpload pictureUpload,
                                  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                  HttpServletRequest req) {
       QueryWrapper<PictureUpload> queryWrapper = QueryGenerator.initQueryWrapper(pictureUpload, req.getParameterMap());
       Page<PictureUpload> page = new Page<PictureUpload>(pageNo, pageSize);
       IPage<PictureUpload> pageList = pictureUploadService.page(page, queryWrapper);
       return Result.ok(pageList);
   }

   /**
    *   添加
    *
    * @param pictureUpload
    * @return
    */
   @AutoLog(value = "图片上传-添加")
   @ApiOperation(value="图片上传-添加", notes="图片上传-添加")
   @PostMapping(value = "/add")
   public Result<?> add(@RequestBody PictureUpload pictureUpload) {
       pictureUploadService.save(pictureUpload);
       return Result.ok("添加成功！");
   }

   /**
    *  编辑
    *
    * @param pictureUpload
    * @return
    */
   @AutoLog(value = "图片上传-编辑")
   @ApiOperation(value="图片上传-编辑", notes="图片上传-编辑")
   @PutMapping(value = "/edit")
   public Result<?> edit(@RequestBody PictureUpload pictureUpload) {
       pictureUploadService.updateById(pictureUpload);
       return Result.ok("编辑成功!");
   }

   /**
    *   通过id删除
    *
    * @param id
    * @return
    */
   @AutoLog(value = "图片上传-通过id删除")
   @ApiOperation(value="图片上传-通过id删除", notes="图片上传-通过id删除")
   @DeleteMapping(value = "/delete")
   public Result<?> delete(@RequestParam(name="id",required=true) String id) {
       pictureUploadService.removeById(id);
       return Result.ok("删除成功!");
   }

   /**
    *  批量删除
    *
    * @param ids
    * @return
    */
   @AutoLog(value = "图片上传-批量删除")
   @ApiOperation(value="图片上传-批量删除", notes="图片上传-批量删除")
   @DeleteMapping(value = "/deleteBatch")
   public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
       this.pictureUploadService.removeByIds(Arrays.asList(ids.split(",")));
       return Result.ok("批量删除成功!");
   }

   /**
    * 通过id查询
    *
    * @param id
    * @return
    */
   @AutoLog(value = "图片上传-通过id查询")
   @ApiOperation(value="图片上传-通过id查询", notes="图片上传-通过id查询")
   @GetMapping(value = "/queryById")
   public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
       PictureUpload pictureUpload = pictureUploadService.getById(id);
       if(pictureUpload==null) {
           return Result.error("未找到对应数据");
       }
       return Result.ok(pictureUpload);
   }

   /**
   * 导出excel
   *
   * @param request
   * @param pictureUpload
   */
   @RequestMapping(value = "/exportXls")
   public ModelAndView exportXls(HttpServletRequest request, PictureUpload pictureUpload) {
       return super.exportXls(request, pictureUpload, PictureUpload.class, "图片上传");
   }

   /**
     * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
   @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
   public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
       return super.importExcel(request, response, PictureUpload.class);
   }

}

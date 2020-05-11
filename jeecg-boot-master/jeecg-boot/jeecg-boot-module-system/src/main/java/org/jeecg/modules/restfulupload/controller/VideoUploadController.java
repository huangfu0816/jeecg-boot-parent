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

import org.jeecg.modules.restfulupload.entity.VideoUpload;
import org.jeecg.modules.restfulupload.service.IVideoUploadService;
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
* @Description: 视频文件参数
* @Author: jeecg-boot
* @Date:   2020-05-06
* @Version: V1.0
*/
@Api(tags="视频文件参数")
@RestController
@RequestMapping("/com.ynyxsoft.lawcase/videoUpload")
@Slf4j
public class VideoUploadController extends JeecgController<VideoUpload, IVideoUploadService> {
   @Autowired
   private IVideoUploadService videoUploadService;

   /**
    * 分页列表查询
    *
    * @param videoUpload
    * @param pageNo
    * @param pageSize
    * @param req
    * @return
    */
   @AutoLog(value = "视频文件参数-分页列表查询")
   @ApiOperation(value="视频文件参数-分页列表查询", notes="视频文件参数-分页列表查询")
   @GetMapping(value = "/list")
   public Result<?> queryPageList(VideoUpload videoUpload,
                                  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                  HttpServletRequest req) {
       QueryWrapper<VideoUpload> queryWrapper = QueryGenerator.initQueryWrapper(videoUpload, req.getParameterMap());
       Page<VideoUpload> page = new Page<VideoUpload>(pageNo, pageSize);
       IPage<VideoUpload> pageList = videoUploadService.page(page, queryWrapper);
       return Result.ok(pageList);
   }

   /**
    *   添加
    *
    * @param videoUpload
    * @return
    */
   @AutoLog(value = "视频文件参数-添加")
   @ApiOperation(value="视频文件参数-添加", notes="视频文件参数-添加")
   @PostMapping(value = "/add")
   public Result<?> add(@RequestBody VideoUpload videoUpload) {
       videoUploadService.save(videoUpload);
       return Result.ok("添加成功！");
   }

   /**
    *  编辑
    *
    * @param videoUpload
    * @return
    */
   @AutoLog(value = "视频文件参数-编辑")
   @ApiOperation(value="视频文件参数-编辑", notes="视频文件参数-编辑")
   @PutMapping(value = "/edit")
   public Result<?> edit(@RequestBody VideoUpload videoUpload) {
       videoUploadService.updateById(videoUpload);
       return Result.ok("编辑成功!");
   }

   /**
    *   通过id删除
    *
    * @param id
    * @return
    */
   @AutoLog(value = "视频文件参数-通过id删除")
   @ApiOperation(value="视频文件参数-通过id删除", notes="视频文件参数-通过id删除")
   @DeleteMapping(value = "/delete")
   public Result<?> delete(@RequestParam(name="id",required=true) String id) {
       videoUploadService.removeById(id);
       return Result.ok("删除成功!");
   }

   /**
    *  批量删除
    *
    * @param ids
    * @return
    */
   @AutoLog(value = "视频文件参数-批量删除")
   @ApiOperation(value="视频文件参数-批量删除", notes="视频文件参数-批量删除")
   @DeleteMapping(value = "/deleteBatch")
   public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
       this.videoUploadService.removeByIds(Arrays.asList(ids.split(",")));
       return Result.ok("批量删除成功!");
   }

   /**
    * 通过id查询
    *
    * @param id
    * @return
    */
   @AutoLog(value = "视频文件参数-通过id查询")
   @ApiOperation(value="视频文件参数-通过id查询", notes="视频文件参数-通过id查询")
   @GetMapping(value = "/queryById")
   public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
       VideoUpload videoUpload = videoUploadService.getById(id);
       if(videoUpload==null) {
           return Result.error("未找到对应数据");
       }
       return Result.ok(videoUpload);
   }

   /**
   * 导出excel
   *
   * @param request
   * @param videoUpload
   */
   @RequestMapping(value = "/exportXls")
   public ModelAndView exportXls(HttpServletRequest request, VideoUpload videoUpload) {
       return super.exportXls(request, videoUpload, VideoUpload.class, "视频文件参数");
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
       return super.importExcel(request, response, VideoUpload.class);
   }

}

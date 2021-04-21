package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.common.Constant;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.service.ChannelService;
import com.hqq.colorful_life.model.service.CreateItemService;
import com.hqq.colorful_life.model.service.SignService;
import com.hqq.colorful_life.model.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Qingqing.He
 * @date 2021/3/23 16:22
 */
@RestController
public class FunctionController {

    public static String getUri ="";
    @Resource
    ChannelService channelService;

    @Resource
    UserService userService;

    @Resource
    SignService signService;

    @Resource
    CreateItemService createItemService;

    /**
     * 图片上传
     * @param servletRequest
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ApiRestResponse upload(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile file){
        //获取原始名字
        String fileName = file.getOriginalFilename();
        //截取原名后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名uuid
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + suffixName;
        //创建文件
        File fileDirectory = new File(Constant.FILE_UPLOAD_DIR);
        //生成目标文件
        File destFile = new File(Constant.FILE_UPLOAD_DIR + newFileName);
        if (!fileDirectory.exists()) {
            if (!fileDirectory.mkdir()){
                throw new UniteException(ExceptionEnum.MKDIR_FAILED);
            }
        }
        try {
            //将传进来的file写入空的目标文件中
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            getUri = getHost(new URI(servletRequest.getRequestURI()+""))+
                "/images/"+newFileName;
            return ApiRestResponse.success(getUri);
        } catch (URISyntaxException e) {
            return ApiRestResponse.error(ExceptionEnum.UPLOAD_FAILED);
        }

    }

    /**
     * 获取返回的路径地址
     * @param uri
     * @return
     */
    public URI getHost(URI uri){
        URI effectiveURI;
        try {
            effectiveURI = new URI(uri.getScheme(),uri.getUserInfo(),uri.getHost(),
                                   uri.getPort(),null,null,null);
        } catch (URISyntaxException e) {
            effectiveURI = null;
        }
        return effectiveURI;
    }

    @ApiOperation("查询所有频道名称")
    @GetMapping("/listChannel")
    public ApiRestResponse listChannel(){
        List<String> channel = channelService.listChannel();
        return ApiRestResponse.success(channel);
    }

    @ApiOperation("签到排行")
    @GetMapping("/signOrder")
    public ApiRestResponse signOrder(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo userOrderBySignNum = userService.findUserOrderBySignNum(pageNum, pageSize);
        return ApiRestResponse.success(userOrderBySignNum);
    }

    @ApiOperation("根据指定频道名称查询签到内容")
    @GetMapping("/listSignByChannelName")
    public ApiRestResponse listSignByChannelName(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String channelName){

        PageInfo pageInfo = signService.listSignByChannelName(pageNum,pageSize,channelName);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("根据指定频道名称查询瞬间内容")
    @GetMapping("/listMomentByChannelName")
    public ApiRestResponse listMomentByChannelName(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String channelName){

        PageInfo pageInfo = createItemService.selectByChannelName(pageNum,pageSize,channelName);
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation("根据指定频道名称查询签到和瞬间内容")
    @GetMapping("/listByChannelName")
    public ApiRestResponse listAllContentByChannelName(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String channelName){

        PageInfo pageInfo = signService.listAllByChannelName(pageNum,pageSize,channelName);
        return ApiRestResponse.success(pageInfo);
    }
}

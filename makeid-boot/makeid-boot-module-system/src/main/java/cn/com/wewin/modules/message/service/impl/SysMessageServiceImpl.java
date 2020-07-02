package cn.com.wewin.modules.message.service.impl;

import cn.com.wewin.modules.message.service.ISysMessageService;
import cn.com.wewin.common.system.base.service.impl.JeecgServiceImpl;
import cn.com.wewin.modules.message.entity.SysMessage;
import cn.com.wewin.modules.message.mapper.SysMessageMapper;
import org.springframework.stereotype.Service;

/**
 * @Description: 消息
 * @Author: jeecg-boot
 * @Date:  2019-04-09
 * @Version: V1.0
 */
@Service
public class SysMessageServiceImpl extends JeecgServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

}

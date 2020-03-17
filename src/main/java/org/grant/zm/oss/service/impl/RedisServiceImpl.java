package org.grant.zm.oss.service.impl;

import io.vavr.control.Option;
import org.grant.zm.oss.base.Contansts;
import org.grant.zm.oss.service.RedisService;
import org.grant.zm.oss.store.FileInfos;
import org.grant.zm.utils.GJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * grant
 * 16/3/2020 3:12 下午
 * 描述：redis 帮助
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    public void addFileId(FileInfos fileInfos){
        redisTemplate.opsForValue().set(Contansts.R_KEY_FILEID + fileInfos.getFileId(), GJsonUtils.toJson(fileInfos));
    }

    public FileInfos getFileInfos(String fileId){
        return Option.of(redisTemplate.opsForValue().get(Contansts.R_KEY_FILEID + fileId))
                .transform(p-> p.isEmpty() ? null : GJsonUtils.toBean(p.get(), FileInfos.class));
    }

}

package com.kedu.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity param);
    UserEntity selUser(UserEntity param);
}

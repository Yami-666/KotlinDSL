package com.example.core.interfaces.data

interface IBaseRepository<LDS : ILocalDataSource, RDS : IRemoteDataSource> :
    IBaseRemoteRepository<RDS>, IBaseLocalRepository<LDS>
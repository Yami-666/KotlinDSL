package com.example.core.interfaces.data

interface IBaseRemoteRepository<RDS: IRemoteDataSource> {
    val remoteDataSource: RDS
}
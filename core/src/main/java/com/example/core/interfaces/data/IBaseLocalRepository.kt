package com.example.core.interfaces.data

interface IBaseLocalRepository<LDS : ILocalDataSource> {
    val localDataSource: LDS
}
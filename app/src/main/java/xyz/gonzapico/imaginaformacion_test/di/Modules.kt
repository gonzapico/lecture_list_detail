package xyz.gonzapico.imaginaformacion_test.di

import org.koin.dsl.module
import xyz.gonzapico.imaginaformacion_test.UserPresenter
import xyz.gonzapico.imaginaformacion_test.UserView

val mvpModule = module {
    factory { (userView: UserView) -> UserPresenter(userView) }
}

val allModules = mvpModule

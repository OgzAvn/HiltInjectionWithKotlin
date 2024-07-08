package com.oguz.hiltinjectionwithkotlin

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ActivityComponentManager
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton

interface MyInterface {

    fun myPrintFunc() : String

}

//Yöntem - 1 -> Bind yöntemi
/*
@InstallIn(ActivityComponentManager::class)
@Module
abstract class MyModule{

    @ActivityScoped
    @Binds
    abstract fun bindingFunction(myImplementor: IntarfaceImplementor) : MyInterface
}
 */


//Provides dış kütüphanelerde(" retrofit, gson ") çalışırken çok daha faydalıdır.
@InstallIn(ApplicationComponentManager::class)
@Module
class MyModule{

    @FirstImplementor
    @Singleton
    @Provides
    fun providerFunction() : MyInterface{
        return IntarfaceImplementor()
    }

    @SecondImplementor
    @Singleton
    @Provides
    fun secondProviderFunction() : MyInterface{

        return SecondInterfaceImplementor()
    }

    //dış kütüphaneler
    @Singleton
    @Provides
    fun gSonProvider() : Gson {
        return Gson()
    }


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirstImplementor



@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondImplementor


/*
Application	   SingletonComponent	        @Singleton
Activity	   ActivityRetainedComponent	@ActivityRetainedScoped
ViewModel	   ViewModelComponent	        @ViewModelScoped
Activity	   ActivityComponent	        @ActivityScoped
Fragment	   FragmentComponent	        @FragmentScoped
View	       ViewComponent	            @ViewScoped
View           annotated with               @WithFragmentBindings	ViewWithFragmentComponent	@ViewScoped
Service	       ServiceComponent	            @ServiceScoped
 */
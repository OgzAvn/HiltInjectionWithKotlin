package com.oguz.hiltinjectionwithkotlin

import javax.inject.Inject
import javax.inject.Singleton

//Constructor Injection
@Singleton
class Musician
    @Inject
    constructor(instrument : Instrument,band: Band)
{

    fun sign() : String{

        return "Working.."
    }
}

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
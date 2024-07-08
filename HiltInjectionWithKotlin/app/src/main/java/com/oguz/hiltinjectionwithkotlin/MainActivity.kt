package com.oguz.hiltinjectionwithkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Field Injection
    @Inject
    lateinit var lars : Musician

    @Inject
    lateinit var myClassExample: ClassExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val instrument = Instrument()
        val band = Band()
        val james = Musician(instrument,band)
        james.sign()

         */

        lars.sign()

        println(myClassExample.myFunction())
        println(myClassExample.SecondFunction())

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

class FragmentExample() : Fragment(){
    @Inject
    lateinit var barisManco : Musician

}
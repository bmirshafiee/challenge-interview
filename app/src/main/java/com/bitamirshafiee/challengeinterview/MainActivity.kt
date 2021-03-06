package com.bitamirshafiee.challengeinterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.bitamirshafiee.challengeinterview.databinding.ActivityMainBinding
import com.bitamirshafiee.challengeinterview.di.repository.component.DaggerRepositoryComponent
import com.bitamirshafiee.challengeinterview.di.repository.component.RepositoryComponent
import com.bitamirshafiee.challengeinterview.di.repository.module.ApplicationModule
import com.bitamirshafiee.challengeinterview.questionlist.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        showFragment(SearchFragment.newInstance())

    }

    fun showFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        fragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.container, fragment)
            addToBackStack(fragment::class.java.toString())
        }
    }

    fun getNetworkingComponent() : RepositoryComponent {
        return DaggerRepositoryComponent.builder().applicationModule(ApplicationModule((application)))
            .build()
    }
}
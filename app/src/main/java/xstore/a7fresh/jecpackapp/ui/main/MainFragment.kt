package xstore.a7fresh.jecpackapp.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*
import xstore.a7fresh.jecpackapp.R
import xstore.a7fresh.jecpackapp.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
            .apply {
                jumpBtn.text = "navigate to second page"
                jumpBtn.setOnClickListener { navigateToSecondPage() }
                jumpThirdBtn.setOnClickListener { navigateToThirdPage() }

                toolbar.setNavigationOnClickListener {
                    Snackbar.make(
                        mainLayout,
                        "Back",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                toolbar.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.action_share -> {
                            createShareIntent()
                            true
                        }
                        else -> false
                    }
                }

            }
        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * 分享
     */
    private fun createShareIntent() {
        Toast.makeText(context, "分享", Toast.LENGTH_SHORT).show()
    }


    /**
     * 跳转到SecondFragment
     */
    private fun navigateToSecondPage() {
        val bundle = bundleOf("second_name" to "我的第二个Fragment")
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_mainFragment_to_secondFragment, bundle)
    }

    /**
     * 跳转到ThirdFragment
     */
    private fun navigateToThirdPage() {
        val action = MainFragmentDirections
            .actionMainFragmentToThirdFragment()
            .setADDRESS("BeiJing CBD...")
        findNavController().navigate(action)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        // 1. 先获取一个ViewModle对象
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        // 2. 定义一个观察者
//        val nameObserver = Observer<String> {
//            message.text = it
//        }
//        // 3.通过使用ViewModle对象进行监听
//        viewModel.name?.observe(this, nameObserver)
//
//
//        message.setOnClickListener {
//            viewModel.doSomeThing()
//        }
//
//    }


}

package xstore.a7fresh.jecpackapp.ui.second

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import xstore.a7fresh.jecpackapp.R
import xstore.a7fresh.jecpackapp.databinding.MainFragmentBinding
import xstore.a7fresh.jecpackapp.databinding.SecondFragmentBinding


class SecondFragment : Fragment() {

    private lateinit var binding: SecondFragmentBinding
    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.second_fragment,container,false)

        arguments?.getString("second_name")?.let { binding.titleTv.text = it }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SecondViewModel::class.java)
    }

    private fun subscribeUi(binding: MainFragmentBinding){
        val observer = Observer<String>{
            viewModel
        }
    }

}

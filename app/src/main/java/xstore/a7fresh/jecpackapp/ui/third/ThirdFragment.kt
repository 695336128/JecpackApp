package xstore.a7fresh.jecpackapp.ui.third

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

import xstore.a7fresh.jecpackapp.databinding.ThirdFragmentBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: ThirdFragmentBinding
    private lateinit var viewModel: ThirdViewModel
    private val safeArgs: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ThirdFragmentBinding.inflate(inflater, container, false)
            .apply {
                binding.addressTv.text = safeArgs.address
            }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ThirdViewModel::class.java)
    }

}

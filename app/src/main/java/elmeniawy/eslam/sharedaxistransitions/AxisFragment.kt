package elmeniawy.eslam.sharedaxistransitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import elmeniawy.eslam.sharedaxistransitions.databinding.FragmentAxisBinding

class AxisFragment : Fragment() {
    private var _binding: FragmentAxisBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        _binding = FragmentAxisBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup layout.
        _binding?.root?.setInsetsPadding(topBottomView = _binding?.layoutRoot)

        // Click listeners.
        _binding?.btXAxis?.setOnClickListener {
            findNavController().navigate(AxisFragmentDirections.actionAxisFragmentToAxisDestinationFragment())
        }

        _binding?.btYAxis?.setOnClickListener {
            findNavController().navigate(AxisFragmentDirections.actionAxisFragmentToAxisDestinationFragment())
        }

        _binding?.btZAxis?.setOnClickListener {
            findNavController().navigate(AxisFragmentDirections.actionAxisFragmentToAxisDestinationFragment())
        }
    }
}
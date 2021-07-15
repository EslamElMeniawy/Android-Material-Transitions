package elmeniawy.eslam.materialtransitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialSharedAxis
import elmeniawy.eslam.materialtransitions.databinding.FragmentSelectTransitionBinding

class SelectTransitionFragment : Fragment() {
    private var _binding: FragmentSelectTransitionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        _binding = FragmentSelectTransitionBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup layout.
        _binding?.root?.setInsetsPadding(topBottomView = _binding?.layoutRoot)

        // Click listeners.
        _binding?.btSharedXAxis?.setOnClickListener {
            setupTransitions(MaterialSharedAxis.X)
            navigate(MaterialSharedAxis.X, _binding?.btSharedXAxis?.text?.toString())
        }

        _binding?.btSharedYAxis?.setOnClickListener {
            setupTransitions(MaterialSharedAxis.Y)
            navigate(MaterialSharedAxis.Y, _binding?.btSharedYAxis?.text?.toString())
        }

        _binding?.btSharedZAxis?.setOnClickListener {
            setupTransitions(MaterialSharedAxis.Z)
            navigate(MaterialSharedAxis.Z, _binding?.btSharedZAxis?.text?.toString())
        }
    }

    private fun setupTransitions(axis: Int) {
        exitTransition = MaterialSharedAxis(axis, true)
        reenterTransition = MaterialSharedAxis(axis, false)
    }

    private fun navigate(axis: Int, title: String?) = findNavController().navigate(
        SelectTransitionFragmentDirections
            .actionSelectTransitionFragmentToTransitionDestinationFragment(axis, title)
    )
}
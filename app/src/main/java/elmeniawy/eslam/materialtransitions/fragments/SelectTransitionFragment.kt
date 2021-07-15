package elmeniawy.eslam.materialtransitions.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialSharedAxis
import elmeniawy.eslam.materialtransitions.databinding.FragmentSelectTransitionBinding
import elmeniawy.eslam.materialtransitions.enums.TransitionTypes
import elmeniawy.eslam.materialtransitions.extensions.setInsetsPadding

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
            setupTransitions(TransitionTypes.SHARED_AXIS, MaterialSharedAxis.X)

            navigate(
                TransitionTypes.SHARED_AXIS,
                _binding?.btSharedXAxis?.text?.toString(),
                MaterialSharedAxis.X
            )
        }

        _binding?.btSharedYAxis?.setOnClickListener {
            setupTransitions(TransitionTypes.SHARED_AXIS, MaterialSharedAxis.Y)

            navigate(
                TransitionTypes.SHARED_AXIS,
                _binding?.btSharedYAxis?.text?.toString(),
                MaterialSharedAxis.Y
            )
        }

        _binding?.btSharedZAxis?.setOnClickListener {
            setupTransitions(TransitionTypes.SHARED_AXIS, MaterialSharedAxis.Z)

            navigate(
                TransitionTypes.SHARED_AXIS,
                _binding?.btSharedZAxis?.text?.toString(),
                MaterialSharedAxis.Z
            )
        }
    }

    private fun setupTransitions(type: TransitionTypes, axis: Int? = null) {
        when (type) {
            TransitionTypes.FADE_THROUGH -> {
            }

            TransitionTypes.FADE -> {
            }

            TransitionTypes.SHARED_AXIS -> {
                axis?.let {
                    exitTransition = MaterialSharedAxis(it, true)
                    reenterTransition = MaterialSharedAxis(it, false)
                }
            }

            TransitionTypes.CONTAINER_TRANSFORMATION -> {
            }

            TransitionTypes.NO_TRANSITION -> {
            }
        }
    }

    private fun navigate(type: TransitionTypes, title: String?, axis: Int? = null) =
        findNavController().navigate(
            SelectTransitionFragmentDirections
                .actionSelectTransitionFragmentToTransitionDestinationFragment(
                    transitionType = type,
                    title = title,
                    axis = axis ?: -1
                )
        )
}
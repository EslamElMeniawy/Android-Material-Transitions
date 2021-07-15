package elmeniawy.eslam.materialtransitions.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialFade
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
import elmeniawy.eslam.materialtransitions.databinding.FragmentTransitionDestinationBinding
import elmeniawy.eslam.materialtransitions.enums.TransitionTypes
import elmeniawy.eslam.materialtransitions.extensions.setInsetsPadding

class TransitionDestinationFragment : Fragment() {
    private var _binding: FragmentTransitionDestinationBinding? = null
    private val _args: TransitionDestinationFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup transition.
        when (_args.transitionType) {
            TransitionTypes.FADE_THROUGH -> {
                enterTransition = MaterialFadeThrough()
                returnTransition = MaterialFadeThrough()
            }

            TransitionTypes.FADE -> {
                enterTransition = MaterialFade()
                returnTransition = MaterialFade()
            }

            TransitionTypes.SHARED_AXIS -> {
                if (_args.axis != -1) {
                    enterTransition = MaterialSharedAxis(_args.axis, true)
                    returnTransition = MaterialSharedAxis(_args.axis, false)
                }
            }

            TransitionTypes.CONTAINER_TRANSFORMATION -> {
            }

            TransitionTypes.NO_TRANSITION -> {
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        _binding = FragmentTransitionDestinationBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup layout.
        _binding?.root?.setInsetsPadding(topBottomView = _binding?.layoutRoot)

        // Add title passed from args to XML.
        _binding?.tvTitle?.text = _args.title
    }
}
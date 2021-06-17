package id.ypran.workouttracker.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import id.ypran.workouttracker.R
import id.ypran.workouttracker.contentView
import id.ypran.workouttracker.databinding.ActivityHomeBinding
import id.ypran.workouttracker.presentation.bottomnavigation.*

class HomeActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener,
    NavController.OnDestinationChangedListener {
    private lateinit var showHideFabStateAction: ShowHideFabStateAction
    private val bottomNavDrawer: BottomNavDrawerFragment by lazy(LazyThreadSafetyMode.NONE) {
        supportFragmentManager.findFragmentById(R.id.bottomNavDrawer) as BottomNavDrawerFragment
    }

    private val binding: ActivityHomeBinding by contentView(R.layout.activity_home)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navHostFragment
        setUpBottomNavigationAndFab()
    }

    private fun setUpBottomNavigationAndFab() {
        // Set a custom animation for showing and hiding the FAB
        binding.fab.apply {
            setShowMotionSpecResource(R.animator.fab_show)
            setHideMotionSpecResource(R.animator.fab_hide)
        }

        binding.fab.setOnClickListener {

        }

        bottomNavDrawer.apply {
            addOnSlideAction(HalfClockwiseRotateSlideAction(binding.bottomAppBarChevron))
            addOnSlideAction(AlphaSlideAction(binding.bottomAppBarTitle, true))
            showHideFabStateAction = ShowHideFabStateAction(binding.fab)
            addOnStateChangedAction(showHideFabStateAction)
            addOnStateChangedAction(ChangeSettingsMenuStateAction { showSettings ->
                // Toggle between the current destination's BAB menu and the menu which should
                // be displayed when the BottomNavigationDrawer is open.
                binding.bottomAppBar.replaceMenu(
                    R.menu.bottom_app_bar_settings_menu
                )
            })

            addOnSandwichSlideAction(HalfCounterClockwiseRotateSlideAction(binding.bottomAppBarChevron))

            // Wrap binding.run to ensure ContentViewBindingDelegate is calling this Activity's
            // setContentView before accessing views
            binding.run {
                findNavController(R.id.navHostFragment).addOnDestinationChangedListener(
                    this@HomeActivity
                )
            }

        }

        // Set up the BottomAppBar menu
        binding.bottomAppBar.apply {
            setNavigationOnClickListener { bottomNavDrawer.toggle() }
            setOnMenuItemClickListener(this@HomeActivity)
        }
        // Set up the BottomNavigationDrawer's open/close affordance
        binding.bottomAppBarContentContainer.apply {
            setOnClickListener { bottomNavDrawer.toggle() }
        }
    }

    override fun onDestinationChanged(
        controller: NavController, destination: NavDestination, arguments: Bundle?,
    ) {
        showHideFabStateAction.dest = destination.id
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_settings -> {
                bottomNavDrawer.close()
            }
            R.id.menu_logout -> {
                bottomNavDrawer.close()
            }
            R.id.menu_search -> {

            }
        }
        return true
    }
}
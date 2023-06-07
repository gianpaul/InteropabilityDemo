package surgir.pe.myapplication.presentation.home

import androidx.activity.viewModels
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import surgir.pe.myapplication.databinding.ActivityMainBinding
import surgir.pe.myapplication.util.nonNullObserve

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val characterAdapter = CharacterAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        binding.recyclerViewCharacters.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewCharacters.adapter = characterAdapter
    }

    private fun setupObservers() {
        viewModel.state.nonNullObserve(this) {
            when (it) {
                is MainState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE

                }
                is MainState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    characterAdapter.setCharacters(it.characters)
                }
                is MainState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    showErrorDialog()
                }
            }
        }
    }
    private fun showErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage("Hubo un error al obtener los personajes.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
package com.d3if4201.myapplication1


import android.app.Activity
import android.content.ActivityNotFoundException
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.d3if4201.myapplication1.databinding.FragmentPersegiBinding

/**
 * A simple [Fragment] subclass.
 */
class PersegiFragment : Fragment() {
    companion object {
        var p = 0
        var l = 0
        var luas = 0
        var keliling = 0
        var keyLuas = "1"
        var keyKeliling = "2"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPersegiBinding>(
            inflater,
            R.layout.fragment_persegi,
            container,
            false
        )
        if (savedInstanceState != null) {
            luas = savedInstanceState.getInt(keyLuas)
            keliling = savedInstanceState.getInt(keyKeliling)
            binding.tvLuas.setText(luas.toString())
            binding.tvKeliling.setText(keliling.toString())
        }

        binding.apply {
            btHitung.setOnClickListener {
                p = etPanjang.text.toString().toInt()
                l = etLebar.text.toString().toInt()
                luas = p * l
                keliling = 2 * (p * l)
                tvLuas.setText(luas.toString())
                tvKeliling.setText(keliling.toString())
            }
            btShare.setOnClickListener() {
                val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                    .setText(getString(R.string.share,p,l, luas, keliling))
                    .setType("text/plain")
                    .intent
                try {
                    startActivity(shareIntent)
                }catch (x:ActivityNotFoundException){
                    Toast.makeText(context, "not found", Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(keyLuas, luas)
        outState.putInt(keyKeliling, keliling)
        super.onSaveInstanceState(outState)
    }
}

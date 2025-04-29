package com.example.appparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appparcial.ui.theme.AppParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            AppParcialTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "retiro"
                ) {
                    composable("retiro") {
                        Retiros(navController)
                    }
                    composable("comprobante/{monto}") { backStackEntry ->
                        val monto = backStackEntry.arguments?.getString("monto") ?: "0"
                        Comprobantes(monto, navController)
                    }
                }
            }
        }
    }
}





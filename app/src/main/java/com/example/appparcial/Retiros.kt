package com.example.appparcial

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appparcial.ui.theme.AppParcialTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Retiros(navController: NavController,
            modifier: Modifier = Modifier)
{
    var saldo by remember { mutableStateOf(1000f) }
    var retiro by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Billetera de Pri")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Text("Saldo: $${"%.2f".format(saldo)}",
                style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(40.dp))
            TextField(
                value = retiro,
                onValueChange = {
                    retiro = it
                },
                label = { Text("Monto a retirar") },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    val monto = retiro.toFloatOrNull()
                    if (monto != null && monto > 0 && monto <= saldo) {
                        saldo -= monto
                        navController.navigate("comprobante/${monto}")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Retirar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RetiroPreview() {
    AppParcialTheme {
        Retiros(navController = rememberNavController())
    }
}


package com.example.prjpam1.Praktikum4

import android.icu.text.IDNA
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prjpam1.Praktikum4.BookingTicketContent
import kotlinx.coroutines.delay

@Composable
fun BookingTicketScreen(){
    val harga = 25000
    var jumlahTiket by rememberSaveable() { mutableIntStateOf(1) }
    var namaPembeli by rememberSaveable() { mutableStateOf("") }
    var status by rememberSaveable() { mutableStateOf("Silakan pesan tiket") }
    var attemptId by rememberSaveable() { mutableIntStateOf(0) }
    val isProcessing = status == "Memproses pesanan..."

    LaunchedEffect(attemptId) {
        if (attemptId == 0) return@LaunchedEffect
        if(namaPembeli.isBlank()){
            status = "Nama harus diisi"
        } else {
            status = "Memproses pesanan..."
            delay(5000)
            status = "Tiket berhasil dipesan!"
        }
    }

    BookingTicketContent(
        jumlahTiket = jumlahTiket,
        namaPembeli = namaPembeli,
        status = status,
        isProcessing = isProcessing,
        onNamaChange = { namaPembeli = it },
        onTambah = { jumlahTiket++ },
        onKurang = { if (jumlahTiket > 1) jumlahTiket-- },
        onPesanClick = { attemptId++ }
    )
}

@Composable
fun BookingTicketContent(
    jumlahTiket: Int,
    namaPembeli: String,
    status: String,
    isProcessing: Boolean,
    onNamaChange: (String) -> Unit,
    onTambah: () -> Unit,
    onKurang: () -> Unit,
    onPesanClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1565D8))
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Text(
                text = "Pemesanan Tiket",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp, top = 30.dp),

                )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            InfoCard {
                Text(
                    "Nama",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(
                    value = namaPembeli,
                    onValueChange = onNamaChange,
                    placeholder = { Text("Masukkan nama Anda") },
                    enabled = !isProcessing,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            InfoCard {
                Text(
                    text = "Jumlah Tiket",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF333333)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically
                ) {
                    CircleIconButton(
                        icon = Icons.Default.Remove,
                        enabled = jumlahTiket > 1,
                        onClick = onKurang
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFEFEFEF))
                            .padding(horizontal = 28.dp, vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = jumlahTiket.toString(),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF222222)
                        )
                    }

                    CircleIconButton(
                        icon = Icons.Default.Add,
                        enabled = true,
                        onClick = onTambah
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            InfoCard {
                Button(
                    onClick = onPesanClick,
                    enabled = !isProcessing,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1565D8),
                        disabledContainerColor = Color(0xFFB0BEC5)
                    )
                ) {
                    Text(
                        text = "Pesan Tiket",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            val (statusBg, statusColor, statusIcon) = when (status) {
                "Nama harus diisi" -> Triple(
                    Color(0xFFFFC9C9),
                    Color(0xFFD32F2F),
                    Icons.Default.Warning
                )

                "Memproses pesanan..." -> Triple(Color(0xFFEAF1FB), Color(0xFF1565D8), null)
                "Tiket berhasil dipesan!" -> Triple(
                    Color(0xFFC4FFD1),
                    Color(0xFF1E8E3E),
                    Icons.Default.CheckCircle
                )

                else -> Triple(Color(0xFFF5F7FA), Color(0xFF666666), null)
            }

            InfoCard {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(statusBg)
                        .padding(20.dp)
                ) {
                    Row(verticalAlignment = CenterVertically) {
                        if (status == "Memproses pesanan...") {
                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                strokeWidth = 2.dp,
                                color = statusColor
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        } else if (statusIcon != null) {
                            Icon(
                                imageVector = statusIcon,
                                contentDescription = null,
                                tint = statusColor,
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                        Text(
                            text = "Status: $status",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = statusColor
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun InfoCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
//            .background(Color.White)
            .padding(16.dp),
        content = content
    )
}

@Composable
private fun CircleIconButton(
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(if (enabled) Color(0xFF1689F8) else Color(0xFFBBDEFB))
            .clickable(enabled = enabled) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookingPreview(){
    BookingTicketScreen()
}
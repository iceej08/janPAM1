package com.example.janpam1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HalamanProfil(){
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Spacer(modifier = Modifier.height(48.dp))

        Box(contentAlignment = Alignment.TopEnd)
        {
            Image(
                painter = painterResource(id = R.drawable.foto_profil),
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Ikon Profil",
                modifier = Modifier.size(30.dp)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Icon Nama",
                modifier = Modifier.size(35.dp) .padding(5.dp)
            )
            Text(
                text = "Nama : Janice Kusuma",
                fontSize = 17.sp
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            Icon(
                imageVector = Icons.Default.Badge,
                contentDescription = "Icon NIM",
                modifier = Modifier.size(35.dp) .padding(5.dp)
            )
            Text(
                text = "NIM     : 245150400111021",
                fontSize = 17.sp,
//                modifier = Modifier.padding(top = 5.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Icon Email",
                modifier = Modifier.size(35.dp) .padding(5.dp)
            )
            Text(
                text = "E-Mail : janicekusumaa@student.ub.ac.id",
                fontSize = 17.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanProfil() {
    HalamanProfil()
}
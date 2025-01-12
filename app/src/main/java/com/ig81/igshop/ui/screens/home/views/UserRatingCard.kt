package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ig81.igshop.R
import com.ig81.igshop.models.uimodels.UserUiModel
import com.ig81.igshop.ui.theme.IGShopTheme

data class User(
    val number: Int,
    val imagePath: String,
    val name: String,
    val balls: Int
)

@Composable
fun UserRatingCard(user: UserUiModel,modifier: Modifier=Modifier){
    val numberAlpha=when(user.rankNumber){
        1->1f
        2->0.5f
        3->0.25f
        else->0f
    }
    Row(modifier = modifier.padding(horizontal = 7.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = user.rankNumber.toString(),
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 14.sp),
            maxLines = 1,

            modifier = Modifier.width(20.dp)

                .alpha(numberAlpha)
           )
Box(Modifier.padding(start = 7.dp, end = 16.dp)
    .size(28.dp,28.dp)
    .clip(MaterialTheme.shapes.small))
    {
        AsyncImage(
            model = user.imagePath,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),



            placeholder = painterResource(R.drawable.ic_user_profile),
            error = painterResource(R.drawable.ic_user_profile)


        )}
        Text(text=user.name,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f))

        Text(text="${user.balls} б.",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium ,
        modifier=Modifier.padding(start = 10.dp)
        )
    }


}


@Preview(showBackground = true,
    backgroundColor = 0xFF4D616C)
@Composable
fun UserRatingCardPreview(){
    IGShopTheme { UserRatingCard(user=UserUiModel(1, "Джонни Джон",136)) }
}
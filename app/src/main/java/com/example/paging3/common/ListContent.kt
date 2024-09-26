package com.example.paging3.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.wear.compose.material.ContentAlpha
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.example.paging3.model.UnsplashImage
import com.example.paging3.model.Urls
import com.example.paging3.model.User
import com.example.paging3.model.UserLinks
import com.example.paging3.R


@ExperimentalCoilApi
@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            count = items.itemCount, // Count of items
            key = { index -> items[index]?.id ?: index } // Safely access the id
        ) { index ->
            val unsplashImage = items[index]
            unsplashImage?.let {
                UnsplashItem(unsplashImage = it)
            }
        }
    }
}




@Composable
fun UnsplashItem(unsplashImage: UnsplashImage, usePreview: Boolean = false) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .clickable {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://unsplash.com/@${unsplashImage.user.userName}?utm_source=DemoApp&utm_medium=referral")
                )
                context.startActivity(browserIntent)
            }
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        if (usePreview) {
            // Use static image for preview
            Icon(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = "Unsplash Image"
            )
        } else {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = unsplashImage.urls.regular,
                contentDescription = "Unsplash Image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder_night)
            )
        }
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black
        ) {}
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(unsplashImage.user.userName)
                    }
                    append(" on Unsplash")
                },
                color = Color.White,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            LikeCounter(
                modifier = Modifier.weight(3f),
                painter = painterResource(id = R.drawable.heart),
                likes = "${unsplashImage.likes}"
            )
        }
    }
}


@Composable
fun LikeCounter(
    modifier: Modifier,
    painter: Painter,
    likes: String
) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painter,
            contentDescription = "Heart Icon",
            tint = Color.Red
        )
        Divider(modifier = Modifier.width(6.dp))
        Text(
            text = likes,
            color = Color.White,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview
fun UnsplashImagePreview() {
    // Providing mock data for preview without using Coil or LazyPagingItems
    UnsplashItem(
        unsplashImage = UnsplashImage(
            id = "1",
            urls = Urls(regular = ""), // Empty URL as we won't load real images in preview
            likes = 100,
            user = User(userName = "Huzaifa", userLink = UserLinks(html = " "))
        )
    )
}


package com.example.dailydigest.presentation.bookmark

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dailydigest.R
import com.example.dailydigest.domain.model.Article
import com.example.dailydigest.presentation.common.ArticlesList
import com.example.dailydigest.util.Dimens.MediumPadding1

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
    ) {
        if (state.articles.isEmpty()) {
            Placeholder()
        } else {
            Text(
                text = "Bookmark",
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.text_title)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            ArticlesList(articles = state.articles, onClick = { navigateToDetails(it) })
        }
    }
}

@Composable
fun Placeholder() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumPadding1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_bookmark), // Replace with your actual placeholder image resource ID
            contentDescription = "No bookmarks",
            tint = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "No bookmarks yet",
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray
        )
    }
}
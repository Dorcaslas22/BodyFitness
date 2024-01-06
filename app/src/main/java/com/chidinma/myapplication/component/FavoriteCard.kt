package com.chidinma.myapplication.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chidinma.myapplication.R
import com.chidinma.myapplication.favoriteCollectionsData
import com.chidinma.myapplication.ui.theme.BodyFitnessTheme

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
){
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.width(192.dp)
        ) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(text = stringResource(id =text),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xdedede)
@Composable
fun FavoriteCollectionCardPreview() {
    BodyFitnessTheme {
        FavoriteCollectionCard(
            text = R.string.fc1_short_mantras,
            drawable = R.drawable.short_mantras,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun FavoriteCollectionGrid(
    modifier: Modifier = Modifier
){
    LazyHorizontalGrid(rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp) ,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement  = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp)
    ){
        items(favoriteCollectionsData){item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text =item.text
            )

        }

    }
}

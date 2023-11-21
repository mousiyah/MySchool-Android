package com.example.MySchool.Components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.MySchool.R
import com.example.MySchool.Screens.Screens

data class MenuItemData (
    val title: String,
    @DrawableRes val iconId: Int,
    val route: String
)

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    items: List<MenuItemData>,
    selectedItemIndex: Int,
    onSelected: (Int) -> Unit
) {
    val items = makeMenuItems()

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        items.forEachIndexed { index, item ->
            MenuItem(
                item = item,
                isSelected = selectedItemIndex == index,
                onSelected = { onSelected(index) },
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun MenuItem(
item: MenuItemData,
isSelected: Boolean,
onSelected: () -> Unit,
modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clickable {
                onSelected.invoke()
            }
            .fillMaxWidth()
            .padding(15.dp, 25.dp, 15.dp, 25.dp)
    ) {
        Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = null,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

fun makeMenuItems(): List<MenuItemData> {
    return listOf(

        MenuItemData(
            R.string.dashboard.toString(),
            R.drawable.ic_dashboard,
            Screens.Dashboard.route),

        MenuItemData(
            R.string.timetable.toString(),
            R.drawable.ic_timetable,
            Screens.Timetable.route),

    )
}

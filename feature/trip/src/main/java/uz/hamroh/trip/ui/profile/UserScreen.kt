package uz.hamroh.trip.ui.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import uz.hamroh.trip.R

@Composable
fun UserScreen(
    userProfile: UserProfile = dummyUser,
    isAppInDarkTheme: Boolean,
) {
    Column {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            ProfileInfo(userProfile)

            Header(text = "Мой профиль")

            Item(
                text = "Изменить данные",
                iconResId = R.drawable.ic_edit_24,
            ) {
            }
            Item (
                text = "Ваши документы",
                iconResId = R.drawable.ic_documents_24,
            )

            Item(
                text = "Платежная информация",
                iconResId = R.drawable.ic_card,
            ) {

            }

            Item(
                text = "Выйти",
                iconResId = R.drawable.ic_sign_out,
            ) {

            }

            Header(text = "Настройки приложения")

            Item(
                text = "Помощь",
                iconResId = R.drawable.ic_help_24,
            ) {
            }

            Item(
                text = "Cообщить об ошибке",
                iconResId = R.drawable.ic_bug,
            ) {

            }

            Item(
                text = "Пожелания и улучшения",
                iconResId = R.drawable.ic_code,
            ) {

            }
        }
    }
}

@Composable
fun ProfileInfo(userProfile: UserProfile) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(userProfile.iconUrl)
                .crossfade(true)
                .build(),
            fallback = painterResource(R.drawable.profile_avatar_placeholder_large),
            error = painterResource(R.drawable.profile_avatar_placeholder_large),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
        )

        Spacer(modifier = Modifier.height(DefaultPadding))

        Text(
            text = userProfile.name ?: "nullable? wtf???",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )

        Text(
            text = userProfile.email,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

val dummyUser = UserProfile(
    "some id",
    "Ваше имя",
    "example@gmail.com",
    "https://301-1.ru/uploads/image/ha-ha-ya-zdes-zhivu_pOLMNliEp9.jpeg",
)

@Composable
fun Header(text: String) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth().padding(vertical = 2.dp)
            .height(HeaderHeight)
            .padding(horizontal = DefaultPadding, vertical = HalfPadding)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.primary),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(horizontal = HalfPadding),
        )
    }
}


@Composable
fun Item(
    text: String,
    @DrawableRes iconResId: Int,
    tailContent: @Composable () -> Unit = {},
    onClick: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(ItemHeight)
            .padding(horizontal = DefaultPadding)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() },
    ) {
        Spacer(modifier = Modifier.width(HalfPadding))

        Image(
            painter = painterResource(id = iconResId),
            contentDescription = text,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary),
            modifier = Modifier.size(IconSize),
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = SmallPadding),
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.fillMaxWidth(0.8f))

        tailContent()
    }
}

@Composable
fun SwitchItem(
    text: String,
    @DrawableRes iconResId: Int,
    checked: Boolean,
    onChecked: (Boolean) -> Unit,
) {
    Item(
        text = text,
        iconResId = iconResId,
        tailContent = {
            var isChecked by remember { mutableStateOf(checked) }
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = !isChecked
                    onChecked(isChecked)
                },
            )

            Spacer(modifier = Modifier.width(12.dp))
        },
    ) {}
}
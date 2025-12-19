package com.example.pertemuan12localrestapi.view



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,

}
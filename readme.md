## Navigation Bar App
Simple project nav bar in compose that uses Lottie images for the screen
### Nav Bar
Very primative nav bar that does not include any nav graph or navigation component. It is just a simple nav bar that uses a `BottomNavigation` and `BottomNavigationItem` to navigate between screens.
### Lottie
- modifier.aspectRation() does little to nothing to the lottie image.
- Compose and LottieAnimation from breaking box by ensuring it does not exceed height and width
- LottieAnimation() contentScale is the only significant way to changes the size of the lottie image
  - ContentScale.FillWidth: stretches the image to fit the width of the container
  - ContentScale.FillHeight: stretches the image to fit the height of the container
  - ContentScale.FillBounds: stretches the image to fit the container
  - ContentScale.Crop: crops the image to fit the container
  - ContentScale.Fit: fits the image to the container
  - ContentScale.Inside: fits the image inside the container without stretching

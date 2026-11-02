# Meating – Android Shopping Application

An Android shopping application for a fictional ready-to-eat meat brand, featuring independently designed UI/UX in Figma and collaboratively developed Android functionality.

## Project Overview

Meating is an Android shopping application developed as a group project for an Android App Development course at National Kaohsiung University of Science and Technology (NKUST).

The project aims to provide customers with a convenient mobile shopping experience for ready-to-eat meat products, integrating product browsing, shopping cart management, membership services, and order management.

I was responsible for the complete UI/UX design of the application using Figma, including its visual identity, interface layouts, navigation structure, and user flows. The designs were subsequently implemented in the Android application by other team members, while the underlying application logic and functionality were developed collaboratively.

## My Contributions

### UI/UX Design – Individual Responsibility

I independently designed the overall UI/UX of the Meating application using Figma.

- Designed the overall visual identity, including the colour palette, typography, branding, and interface style.
- Created the application's navigation structure and user flows.
- Designed layouts for key screens, including the home page, product catalogue, login and registration, shopping cart, checkout, member profile, and order history.
- Designed the administrative interface, including inventory management screens.
- Maintained a consistent visual experience across different application sections.

### Android Application Development – Group Collaboration

The Android application was implemented collaboratively by the project team based on the Figma designs.

The group's development work covered:

- Android application development using Java.
- Implementation of application navigation and user interfaces.
- Product browsing and shopping cart functionality.
- Membership and account management.
- Order processing and local data storage.
- Integration of Android components and device features.

## UI/UX Design – Figma

The complete application interface was independently designed in Figma before implementation. The design established the visual direction, navigation structure, and user experience across customer-facing and administrative functions.

📱 **[View Complete Original Figma Design](https://www.figma.com/design/wJNc1m53s84f4AR43IcyaF/MEATING-Application-Project?t=SbxSSODQokVkWC14-1)**

### Selected Figma Design Screens

The following screenshots showcase my original UI/UX design work created in Figma.

#### Home Screen and Navigation

<p align="center">
  <img src="screenshots/figma/home-screen.png" width="600" alt="Meating home screen Figma design">
</p>

#### Product Catalogue

<p align="center">
  <img src="screenshots/figma/product-catalogue.png" width="600" alt="Product catalogue Figma design">
</p>

#### Shopping Cart and Checkout

<p align="center">
  <img src="screenshots/figma/shopping-cart.png" width="600" alt="Shopping cart Figma design">
</p>

<p align="center">
  <img src="screenshots/figma/checkout.png" width="600" alt="Checkout Figma design">
</p>

#### Membership and Order History

<p align="center">
  <img src="screenshots/figma/member-profile.png" width="600" alt="Member profile Figma design">
</p>

<p align="center">
  <img src="screenshots/figma/order-history.png" width="600" alt="Order history Figma design">
</p>

#### Administrative Interface

<p align="center">
  <img src="screenshots/figma/inventory-management.png" width="600" alt="Inventory management Figma design">
</p>

## Selected Implemented Android App Screens

The Figma designs were translated into the Android application by other team members. The following screenshots demonstrate the implemented application and its interface.

#### Home Screen

<p align="center">
  <img src="screenshots/android-app/home-screen.png" width="600" alt="Implemented Android home screen">
</p>

#### Product Browsing and Shopping

<p align="center">
  <img src="screenshots/android-app/product-catalogue.png" width="600" alt="Implemented Android product catalogue">
</p>

#### Shopping Cart

<p align="center">
  <img src="screenshots/android-app/shopping-cart.png" width="600" alt="Implemented Android shopping cart">
</p>

#### Membership and Order History

<p align="center">
  <img src="screenshots/android-app/member-profile.png" width="600" alt="Implemented Android member profile">
</p>

## Key Features

### 1. Product Browsing and Shopping

- Browse ready-to-eat meat products.
- View product images, descriptions, and prices.
- Select products and quantities for purchase.

### 2. Shopping Cart and Checkout

- Add products to the shopping cart.
- Adjust product quantities and review selected items.
- Calculate order totals, including delivery fees.
- Enter recipient and delivery information.
- Select from the payment options presented in the checkout interface.
- Display order submission confirmation.

### 3. Membership Management

- Register and log in to a member account.
- View personal profile information.
- Access membership-related functions.
- Review previous purchase records.

### 4. Order History

- Display previous orders and their order numbers.
- Review order amounts and order statuses.

### 5. Inventory Management

- Provide an administrative inventory interface.
- Display product stock quantities, names, and prices.
- Present expiry-date and stock information for inventory management.

## Technologies Used

### Design

- **UI/UX Design:** Figma

### Application Development

- **Programming Language:** Java
- **Platform:** Android
- **UI Development:** Android XML Layouts
- **Build System:** Gradle (Kotlin DSL)
- **Local Database:** SQLite
- **Local Data Storage:** SharedPreferences
- **Android Components:** Activities, Fragments, DialogFragment
- **Android Features:** Intents, Notifications, BroadcastReceiver, Toast, Navigation Drawer

## Application Architecture

The application follows a standard Android project structure, with an Activity as the main entry point and separate components for membership, product selection, and database operations.

### Main Components

| Component | Responsibility |
|---|---|
| `MainActivity.java` | Main application activity, navigation, product loading, shopping flow, and application-level event handling. |
| `RegisterActivity.java` | Handles member registration. |
| `DBHelper.java` | Manages the local SQLite database and table creation. |
| `ProductDialogFragment.java` | Displays product selection options and size-dependent pricing. |
| `LoginDialogFragment.java` | Provides the member login dialog. |
| `LoginOutListener.java` | Supports login and logout event handling. |
| `ui/` | Contains UI-related packages and application fragments. |

### Data Storage

The application uses local data storage for different purposes:

- **SharedPreferences:** Stores local account credentials and user preferences.
- **SQLite Database:** Stores purchase records and related order information.
- **XML Resources:** Provides product information used by the application.

## How to Run

### Prerequisites

- Android Studio
- Android SDK compatible with the project configuration
- JDK compatible with the Gradle configuration
- Android Emulator or a physical Android device

### Setup Instructions

**1. Download or clone the repository**

Download the project files or clone this repository to your local machine.

**2. Open the project in Android Studio**

- Launch Android Studio.
- Select **Open**.
- Navigate to the downloaded project root folder.
- Open the folder containing `settings.gradle.kts` and `build.gradle.kts`.

**3. Synchronise Gradle**

Allow Android Studio to synchronise the Gradle project and download the required dependencies.

**4. Configure an Android device**

- Start an Android Emulator or connect a physical Android device.
- Enable USB debugging if using a physical device.

**5. Run the application**

- Select the `app` run configuration in Android Studio.
- Choose the target emulator or connected device.
- Click **Run** to install and launch the application.

## What I Learned

Through this group project, I gained experience in:

- Independently designing a complete mobile application UI/UX in Figma.
- Developing a consistent visual identity and navigation structure across multiple application screens.
- Translating user requirements into interface layouts and user journeys.
- Understanding the relationship between UI/UX design and Android application implementation.
- Collaborating with team members throughout the application development process.
- Understanding mobile shopping workflows, including product selection, cart management, checkout, and membership services.
- Gaining practical exposure to Android development concepts and local data management.

## Additional Documentation

The original project report in Traditional Chinese (繁體中文) is available in PDF format.

[View Traditional Chinese Project Documentation](docs/Meating-Android-Project-Report-zh-TW.pdf)

## Project Information

- **Project Name:** Meating
- **Project Type:** Academic Group Project
- **Course:** Android App Development
- **Institution:** National Kaohsiung University of Science and Technology (NKUST)
- **Individual Contribution:** UI/UX Design
- **Design Tool:** Figma
- **Application Platform:** Android
- **Programming Language:** Java
- **Completion Date:** January 2024

---

*This project was developed for academic purposes as a collaborative exercise in mobile application design and development.*

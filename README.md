# Demo App using a Coordinator Pattern on Android

This project is a demonstration of using a coordinator pattern in conjunction with the Android
architecture components for navigation. By using this pattern we are able to abstract out any logic
associated with navigation, which provides the following benefits:

-  We can write unit tests around our navigation logic. This sample is *very* simple. However,
in a more complex app there could be more business logic here and with this approach it is much
more testable
-  We can use this pattern in an app with a single Activty (and multiple fragments), or in a
multi-activity approach. It allows you to inject your coordinator dependency to launch a particular
flow from multiple places in your app. The benefit here is that you don't have to worry about
retesting at the new integration point, because it is the exact same code-path.

# Dependencies
- androidx navigation -> this is to use the navigation components
- androidx architecture components -> this is mainly to just use the Viewmodels
- rxJava -> very lightweight here, however it shows how a repository pattern might function in the model layer

# Basic structure for Coordinators
- `Coordinator` -> this is the class that will know where to navigate next when a flow is launched
or there is some interaction by the user
- `Navigator` -> this is the abstraction for the android navigation component. It is only responsible
for knowing how to navigate. I chose to use a `NavigationController` here, however you could use
any mechanism for navigation
- `Screen` -> A sealed class that defines what "screens" can be navigated to in a single flow.

For more details, please refer to the wiki.

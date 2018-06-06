# AtlasClassLoader
 * The Atlas Loader
 * This is a classloader , with dynamic class removal feature.
 * How this is achieved?
 * The idea came from Mario Ortegón(https://stackoverflow.com/users/2309/mario-orteg%c3%b3n) in this stackoverflow post -> https://stackoverflow.com/questions/148681/unloading-classes-in-java
 * And in brief description , every class can be removed , if his class loader is also garbage collected . so the
 * Atlas Loader just manages SingleClassLoaders , a loader witch only allowed to load one class (with call to .resolveIt()) . when the removal is needed
 * the only thing needed is to garbage collect the responsible class loader .
 * @implNote when .removeClass(java.lang.String) is called , it is assumed that every object of this class is also garbage collected
 * @implNote this class have no security responsibility , the specific implementation of SingleClassLoader has . the AtlasLoader is a dummy wrapper over
 * a bunch of SingleClassLoaders, nothing more!
 *

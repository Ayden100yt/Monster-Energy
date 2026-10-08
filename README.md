# Monster Energy - Fabric + Forge (Minecraft 26.1 - 26.2)

Needs **JDK 25**.

## Build
```
.\gradlew.bat build
```
Both jars end up in `build\libs\`:
- `monster-energy-fabric-1.0.0.jar` - Fabric (also needs Fabric API) for 26.1, 26.1.1, 26.1.2, 26.2
- `monster-energy-forge-1.0.0.jar`  - Forge for 26.1, 26.1.1, 26.1.2, 26.2

## Test in game
```
.\gradlew.bat runFabricClient
.\gradlew.bat runForgeClient
```

## Folders
- `common/` - shared by both loaders
  - `src/main/java/com/ayden/monsterenergy/MonsterEnergy.java` - the can: effects, stack size, rarity
  - `src/main/resources/` - 3D model, textures, names, recipe
- `fabric/` - Fabric entry point (`MonsterEnergyFabric.java`), `fabric.mod.json`, Fabric versions in `gradle.properties`
- `forge/`  - Forge entry point (`MonsterEnergyForge.java`), `META-INF/mods.toml`, Forge versions in `gradle.properties`

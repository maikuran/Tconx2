# 1.16.5 validation notes

- Target: Minecraft 1.16.5 / Forge 36.2.42 / Tinkers' Construct 3.3.4.335 / Mantle 1.6.157.
- All JSON resources parse successfully.
- Local model parent references were checked and none are missing.
- Rank mapping is enforced as Rank 1 -> harvest 3, Rank 2 -> harvest 4, Rank 3 -> harvest 5.
- Babelium alloy recipe is present: 48 mB Situan + 48 mB Magnum + 48 mB Osium -> 144 mB Babelium.
- Ore generation event is registered only by @Mod.EventBusSubscriber; duplicate manual registration was removed.
- TConstruct dependency range is limited to the 3.3.x 1.16.5 line.
- Java compilation could not be executed in this environment because the Gradle 7.1 distribution and Forge/TConstruct dependency artifacts were not locally cached and external Gradle downloads are unavailable.

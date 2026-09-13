# Nexaris — Development Conventions

Internal conventions for this project. Keep this in sync if the structure
changes — this is the reference for "where does X go" and "how do we name
Y", so future-you (or anyone else working on this) doesn't have to guess.

## Package Structure

```
de.snulian.nexaris
├── Nexaris.java              # Main mod class, @Mod entrypoint
├── NexarisClient.java        # Client-only entrypoint
├── block/
│   ├── ModBlocks.java        # DeferredRegister for all blocks
│   └── entity/
│       ├── ModBlockEntities.java
│       └── <Machine>BlockEntity.java   # one file per machine
├── item/
│   └── ModItems.java         # DeferredRegister for all items
├── energy/
├── recipe/
│   ├── ModRecipes.java
│   └── <Machine>Recipe.java  # one file per recipe type
├── screen/
│   ├── ModMenuTypes.java
│   ├── <Machine>Menu.java
│   └── <Machine>Screen.java
├── datagen/
├── config/
│   └── ModConfig.java
└── util/
    └── ModUtil.java
```

Rule of thumb: organized by **content type** (all blocks together, all
items together), not by machine. Each individual machine still gets its
own file within the relevant folder (e.g. `CrusherBlockEntity.java`,
`SmelterBlockEntity.java` both live in `block/entity/`).

## Naming Rules

- **Registry IDs**: `snake_case`, always built through the central helper
  `ModUtil.id("crusher")` — never inline a `ResourceLocation` with the
  modid hardcoded.
- **MODID**: defined once as `public static final String MODID` in
  `Nexaris.java`. Always reference `Nexaris.MODID`, never re-type the
  string `"nexaris"` elsewhere.
- **Registry classes**: consistent `Mod` prefix — `ModBlocks`, `ModItems`,
  `ModBlockEntities`, `ModRecipes`, `ModMenuTypes`. Never mix naming
  styles (no `BlockRegistry`, no bare `Blocks`).
- **No wildcard imports.** Spotless removes them automatically on
  `spotlessApply`, but don't rely on that — write explicit imports.
- **`@Override` always explicit.**

## Config — No Magic Numbers

Every tunable number (energy capacity, processing time, FE/tick cost,
etc.) lives in `ModConfig`, never hardcoded in a `BlockEntity`.

```java
// bad
private int energyCapacity = 10000;

// good
private int energyCapacity = ModConfig.CRUSHER_ENERGY_CAPACITY.get();
```

Reasoning: when the same value needs tuning across multiple machines
(e.g. rebalancing all Tier 0 energy costs at once), you edit one config
file instead of hunting through BlockEntity classes.

## Formatting

Handled by Spotless (`palantirJavaFormat`) — run `./gradlew spotlessApply`
before committing, `spotlessCheck` runs in CI and will fail the build on
violations. Don't hand-format; let the tool do it.

## Commit Convention

Conventional Commits, matching the CI/workflow setup:

```
feat(crusher): add processing progress sync via ContainerData
fix(energy): prevent negative buffer on partial extract
refactor(block): extract AbstractMachineBlockEntity
docs: document recipe JSON format
chore(deps): bump neoforge to 21.1.xxx
```

Common scopes: `block`, `item`, `energy`, `recipe`, `screen`, `datagen`,
`config`.

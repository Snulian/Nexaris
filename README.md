<div style="text-align: center;">

# Nexaris

**A tech mod for Minecraft, built on NeoForge.**

[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-62B47A?logo=minecraft)](https://www.minecraft.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1-orange)](https://neoforged.net/)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)
[![Status](https://img.shields.io/badge/status-early%20development-yellow)]()

</div>

---

## About

Long before the Overworld was settled, the **Nexarians** built an advanced civilization powered by a single material: **Nexite**. Their facilities lie buried today — and their machines can be brought back online.

Nexaris is a classic tech mod centered around energy generation, storage, and processing, inspired by mods like Mekanism and Draconic Evolution. Rather than reinventing the wheel, it plugs into the existing FE-based energy ecosystem, so it plays well alongside other tech mods.

## Planned Features

- ⚡ **Energy** on the standard FE system, compatible with the wider mod ecosystem
- 🔋 **Generators** — from simple combustion to advanced late-game tiers
- 🗄️ **Energy storage** in multiple capacity stages
- ⚙️ **Machines** — crusher, furnace, refinery, and more
- 🪨 **Material chain** — Nexite → Refined Nexite → Nexite Alloy → Awakened Nexite
- 🔧 Fully configurable energy values and processing times
- 📖 JEI integration for recipe lookup

## Status

**Early development.** Nexaris is not yet playable — there are no releases and no public builds. Watch this repository to follow progress.

## Tech Stack

| | |
|---|---|
| Minecraft | 1.21.1 |
| Mod Loader | NeoForge 21.1.x |
| Java | 21 |
| Build | Gradle (ModDevGradle) |

## Building from Source

```bash
git clone git@github.com:Snulian/Nexaris.git
cd Nexaris
./gradlew build
```

Run a development client with:

```bash
./gradlew runClient
```

## Contributing

Nexaris is currently a solo learning project and not open for contributions yet. Feel free to open an issue if you spot something worth flagging.

## License

Nexaris is licensed under the [MIT License](LICENSE).

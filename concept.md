# Nexaris — Concept

## Lore

Long before the Overworld was settled, the **Nexarians** built an advanced
civilization powered by a single material: **Nexite**. Their facilities lie
buried today — and their machines can be brought back online.

## Tier Overview (long-term)

| Tier | Name | Material | Status |
|---|---|---|---|
| 0 | Basis | Nexite Ingot | **Version 1 — in progress** |
| 1 | Refined | Refined Nexite | planned |
| 2 | Alloy | Nexite Alloy | planned |
| 3 | ? | TBD | planned |
| 4 | ? (possibly "Resonant Nexite") | TBD | planned |

Tiers unlock **linearly** — no separate research/skill gate, the material
itself is the progression gate. Each tier's machines are upgrades of the
previous tier's machines (same machine, better stats), not new separate
machines.

## Version 1 Scope (Tier 0 only)

Goal: a small, complete, playable slice — not a full tech tree. Everything
below is meant to be buildable and testable end-to-end before any Tier 1
content starts.

### Material Chain (Tier 0)

```
Nexite Ore (world gen, mineable at Iron tier)
    │
    ├── Smelter ──────────► Nexite Ingot
    │
    └── Crusher ──────────► 2x Nexite Dust ──► Smelter ──► Nexite Ingot
```

- Crusher applies standard ore-doubling: 1 ore → 2 dust (same pattern used
  by most tech mods, e.g. Mekanism/Thermal).
- Crusher works on **all standard ores** too (iron, gold, copper, etc.), not
  just Nexite — general-purpose doubling machine.
- Smelter handles both raw ore and dust → ingot, plus normal vanilla
  smelting recipes.
- **Refiner is intentionally excluded from V1** — it has no real job until
  Tier 1 (Refined Nexite) exists. Gets added when Tier 1 starts.

### Machines (all single-block in V1)

| Machine | Function | Tier behavior (future) |
|---|---|---|
| **Smelter** | ore/dust → ingot, vanilla smelting | higher tier = faster, more slots |
| **Crusher** | ore doubling (all ores, not just Nexite) | higher tier = faster, more slots |

Both get a config-driven processing time and energy cost (no hardcoded
numbers in the BlockEntity — see `dev-conventions.md`).

### Energy

**Energy Core (Multiblock)**
- Pure storage — does **not** generate energy
- One energy input port, one energy output port
- Capacity scales with tier (Tier 0 = base capacity)
- Visual: floating core controlled by a terminal, with stabilizers on the
  sides — purely aesthetic, cannot explode
- Modifier system planned for later (extend capacity / input / output) —
  not implemented in V1

**Generators (single-block, two options in V1)**
- **Coal Generator** — burns coal/any burnable fuel, baseline energy source
- **Nexite Generator (Tier 0)** — burns/consumes Nexite for a better energy
  rate than the coal generator
- Both available from the start, no artificial gating between them

**Reactor (Multiblock)** — explicitly **not** in V1. Planned as a
later, higher-tier energy source (Nexite + secondary element/material
reacting, chamber-style, terminal + stabilizers like the Energy Core, no
explosion — possible meltdown/failure system considered for much later).

### Storage

- **Item storage**: single-block chest-equivalent, Tier 0
- **Fluid storage**: single-block tank, Tier 0
- Multiblock storage (warehouses etc.) is a later-tier idea, not in V1

### Transport

- **Energy cable** — throughput scales with tier
- **Item/fluid transport cable** — throughput scales with tier
- Tier 0 only for V1

### Equipment

- Pickaxe, Sword, Armor set (Tier 0)
- Stats roughly at **Netherite level**
- Normal durability (not energy-based in V1 — energy-based tools are a
  later-tier idea)
- No modifiers in V1

### Explicitly Deferred to Later Tiers

- Refiner (starts at Tier 1, converts Ingot → Refined Nexite, and later
  produces the secondary elements needed for the Reactor)
- Reactor multiblock (energy generation via Nexite + element combination)
- Autocrafter (Create-style scaling recipes, later AE2 integration)
- Modifiers for any machine, cable, or equipment
- Energy-based equipment durability
- Multiblock upgrades for Smelter/Crusher/Refiner
- Multiblock storage
- Higher tiers of ore (Nexite itself stays Tier 0 material; refinement
  produces the higher-tier materials, not new ore types)

## Open Naming Question

Tier names for 1–4 still undecided beyond "Refined Nexite" and
"Nexite Alloy". Candidate for Tier 4: **Resonant Nexite** (ties into the
energy/reactor theme of the Nexarian civilization without leaning on
"Awakened"-style Draconic Evolution naming). Not locked in yet.

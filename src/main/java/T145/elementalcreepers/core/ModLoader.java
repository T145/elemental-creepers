package T145.elementalcreepers.core;

import T145.elementalcreepers.ElementalCreepers;
import T145.elementalcreepers.client.render.entity.RenderAngryCreeper;
import T145.elementalcreepers.client.render.entity.RenderBaseCreeper;
import T145.elementalcreepers.client.render.entity.RenderFriendlyCreeper;
import T145.elementalcreepers.client.render.entity.RenderSpiderCreeper;
import T145.elementalcreepers.config.ModConfig;
import T145.elementalcreepers.entities.*;
import T145.elementalcreepers.entities.base.EntityBaseCreeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModLoader {

    public static final ArrayList<Class> CREEPER_REGISTRY = new ArrayList<>();

    private ModLoader() {}

    @EventBusSubscriber(modid = ElementalCreepers.MODID)
    public static class ServerLoader {

        private static int entityId;
        private static BiomeDictionary.Type[] validOverworldBiomeTypes = {BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.MOUNTAIN};

        private ServerLoader() {}

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {

            // TODO: Add unique egg colors
            final EntityEntry[] entries = {
                    createCreeperBuilder("CakeCreeper")
                            .entity(EntityCakeCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("CookieCreeper")
                            .entity(EntityCookieCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("DarkCreeper")
                            .entity(EntityDarkCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("EarthCreeper")
                            .entity(EntityEarthCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("EnderCreeper")
                            .entity(EntityEnderCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("FireCreeper")
                            .entity(EntityFireCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("FireworkCreeper")
                            .entity(EntityFireworkCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("FurnaceCreeper")
                            .entity(EntityFurnaceCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("FriendlyCreeper")
                            .entity(EntityFriendlyCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("GhostCreeper")
                            .entity(EntityGhostCreeper.class)
                            .build(),
                    createCreeperBuilder("BallisticCreeper")
                            .entity(EntityBallisticCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("IceCreeper")
                            .entity(EntityIceCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("IllusionCreeper")
                            .entity(EntityIllusionCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("LightCreeper")
                            .entity(EntityLightCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("LightningCreeper")
                            .entity(EntityLightningCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("MagmaCreeper")
                            .entity(EntityMagmaCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("PsychicCreeper")
                            .entity(EntityPsychicCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("ReverseCreeper")
                            .entity(EntityReverseCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("SpiderCreeper")
                            .entity(EntitySpiderCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("SpringCreeper")
                            .entity(EntitySpringCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("StoneCreeper")
                            .entity(EntityStoneCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("WaterCreeper")
                            .entity(EntityWaterCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("WindCreeper")
                            .entity(EntityWindCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build(),
                    createCreeperBuilder("ZombieCreeper")
                            .entity(EntityZombieCreeper.class)
                            .egg(0x0DA70B, 0x101010)
                            .build()
            };

            for (EntityEntry entry : entries) {
                event.getRegistry().register(entry);
                CREEPER_REGISTRY.add(entry.getEntityClass());
            }

            if (ModConfig.general.reasonableSpawnRates) {
                addOverworldSpawn(EntityFireCreeper.class, ModConfig.spawnRate.fireCreeperSpawn, 3);
                addOverworldSpawn(EntityWaterCreeper.class, ModConfig.spawnRate.waterCreeperSpawn, 3);
                addOverworldSpawn(EntityLightningCreeper.class, ModConfig.spawnRate.lightningCreeperSpawn, 3);
                addOverworldSpawn(EntityCookieCreeper.class, ModConfig.spawnRate.cookieCreeperSpawn, 2);
                addOverworldSpawn(EntityDarkCreeper.class, ModConfig.spawnRate.darkCreeperSpawn, 3);
                addOverworldSpawn(EntityLightCreeper.class, ModConfig.spawnRate.lightCreeperSpawn, 3);
                addOverworldSpawn(EntityEarthCreeper.class, ModConfig.spawnRate.earthCreeperSpawn, 3);
                addOverworldSpawn(EntityReverseCreeper.class, ModConfig.spawnRate.reverseCreeperSpawn, 1);
                addOverworldSpawn(EntityIceCreeper.class, ModConfig.spawnRate.iceCreeperSpawn, 3);
                addOverworldSpawn(EntityPsychicCreeper.class, ModConfig.spawnRate.psychicCreeperSpawn, 3);
                addOverworldSpawn(EntityIllusionCreeper.class, ModConfig.spawnRate.illusionCreeperSpawn, 1);
                addOverworldSpawn(EntitySpiderCreeper.class, ModConfig.spawnRate.spiderCreeperSpawn, 3);
                addOverworldSpawn(EntityWindCreeper.class, ModConfig.spawnRate.windCreeperSpawn, 2);
                addOverworldSpawn(EntityBallisticCreeper.class, ModConfig.spawnRate.ballisticCreeperSpawn, 1);
                addOverworldSpawn(EntityEnderCreeper.class, ModConfig.spawnRate.enderCreeperSpawn, 2);
                addOverworldSpawn(EntityStoneCreeper.class, ModConfig.spawnRate.stoneCreeperSpawn, 3);
                addOverworldSpawn(EntityCakeCreeper.class, ModConfig.spawnRate.cakeCreeperSpawn, 3);
                addOverworldSpawn(EntityFireworkCreeper.class, ModConfig.spawnRate.fireworkCreeperSpawn, 3);
                addOverworldSpawn(EntitySpringCreeper.class, ModConfig.spawnRate.springCreeperSpawn, 3);
                addOverworldSpawn(EntityFurnaceCreeper.class, ModConfig.spawnRate.furnaceCreeperSpawn, 3);
                addOverworldSpawn(EntityZombieCreeper.class, ModConfig.spawnRate.zombieCreeperSpawn, 1);
            } else {
                copyCreeperSpawns(EntityCakeCreeper.class);
                copyCreeperSpawns(EntityCookieCreeper.class);
                copyCreeperSpawns(EntityDarkCreeper.class);
                copyCreeperSpawns(EntityEarthCreeper.class);
                copyCreeperSpawns(EntityEnderCreeper.class);
                copyCreeperSpawns(EntityFireCreeper.class);
                copyCreeperSpawns(EntityFireworkCreeper.class);
                copyCreeperSpawns(EntityFurnaceCreeper.class);
                copyCreeperSpawns(EntityBallisticCreeper.class);
                copyCreeperSpawns(EntityIceCreeper.class);
                copyCreeperSpawns(EntityIllusionCreeper.class);
                copyCreeperSpawns(EntityLightCreeper.class);
                copyCreeperSpawns(EntityLightningCreeper.class);
                copyCreeperSpawns(EntityMagmaCreeper.class);
                copyCreeperSpawns(EntityPsychicCreeper.class);
                copyCreeperSpawns(EntityReverseCreeper.class);
                copyCreeperSpawns(EntitySpiderCreeper.class);
                copyCreeperSpawns(EntitySpringCreeper.class);
                copyCreeperSpawns(EntityStoneCreeper.class);
                copyCreeperSpawns(EntityWaterCreeper.class);
                copyCreeperSpawns(EntityWindCreeper.class);
                copyCreeperSpawns(EntityZombieCreeper.class);
            }

            addOverworldSpawn(EntityFriendlyCreeper.class, ModConfig.spawnRate.friendlyCreeperSpawn, 2, EnumCreatureType.CREATURE);
            addNetherSpawn(EntityFireCreeper.class, ModConfig.spawnRate.fireCreeperSpawn, 3);
            addNetherSpawn(EntityMagmaCreeper.class, ModConfig.spawnRate.magmaCreeperSpawn, 2);
            addEndSpawn(EntityEnderCreeper.class, ModConfig.spawnRate.enderCreeperSpawn * 5, 3);

            // TODO: Add dimension blacklist/whitelist
        }

        private static <C extends Entity> EntityEntryBuilder<C> createCreeperBuilder(final String name) {
            final EntityEntryBuilder<C> builder = EntityEntryBuilder.create();
            final ResourceLocation registryName = new ResourceLocation(ElementalCreepers.MODID, name);
            return builder
                    .id(registryName, entityId++)
                    .name(ElementalCreepers.MODID + ":" + name)
                    .tracker(80, 3, true);
        }

        static void addOverworldSpawn(Class<? extends EntityLiving> entityClass, int spawnprob, int max, EnumCreatureType type) {
            for (BiomeDictionary.Type biomeType : validOverworldBiomeTypes) {
                Set<Biome> biomeSet = BiomeDictionary.getBiomes(biomeType);
                EntityRegistry.addSpawn(entityClass, spawnprob, 1, max, type, biomeSet.toArray(new Biome[0]));
            }
        }

        static void addOverworldSpawn(Class<? extends EntityLiving> entityClass, int spawnprob, int max) {
            addOverworldSpawn(entityClass, spawnprob, max, EnumCreatureType.MONSTER);
        }

        static void addNetherSpawn(Class<? extends EntityLiving> entityClass, int spawnprob, int max) {
            Set<Biome> biomeSet = BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER);
            EntityRegistry.addSpawn(entityClass, spawnprob, 1, max, EnumCreatureType.MONSTER, biomeSet.toArray(new Biome[0]));
        }

        static void addEndSpawn(Class<? extends EntityLiving> entityClass, int spawnprob, int max) {
            Set<Biome> biomeSet = BiomeDictionary.getBiomes(BiomeDictionary.Type.END);
            EntityRegistry.addSpawn(entityClass, spawnprob, 1, max, EnumCreatureType.MONSTER, biomeSet.toArray(new Biome[0]));
        }

        private static void copyCreeperSpawns(final Class<? extends EntityLiving> classToAdd) {
            for (final Biome biome : ForgeRegistries.BIOMES) {
                biome.getSpawnableList(EnumCreatureType.MONSTER).stream().filter(entry -> entry.entityClass == EntityCreeper.class).findFirst().ifPresent(spawnListEntry -> biome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(classToAdd, spawnListEntry.itemWeight, spawnListEntry.minGroupCount, spawnListEntry.maxGroupCount)));
            }
        }

        @SubscribeEvent
        public static void onEntityDeath(LivingDeathEvent event) {
            DamageSource damage = event.getSource();
            Entity trueSource = damage.getTrueSource();
            EntityLivingBase entity = event.getEntityLiving();
            boolean killedByPlayer = damage.getDamageType().equals("player") || trueSource instanceof EntityPlayer;

            if (killedByPlayer && entity instanceof EntityCreeper && !(entity instanceof EntityGhostCreeper) && !(entity instanceof EntityFriendlyCreeper)) {
                if (entity instanceof EntityIllusionCreeper && ((EntityIllusionCreeper) entity).isIllusion()) {
                    return;
                }

                if (entity.world.rand.nextInt(100) < ModConfig.general.ghostCreeperChance) {
                    EntityGhostCreeper ghost = new EntityGhostCreeper(entity.world);
                    ghost.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
                    entity.world.spawnEntity(ghost);
                }
            }

            // TODO: Add HashSet entity blacklist
            if (entity instanceof IMob) {
                int radius = ModConfig.general.zombieCreeperRange;
                AxisAlignedBB bb = new AxisAlignedBB(entity.posX - radius, entity.posY - radius, entity.posZ - radius, entity.posX + radius, entity.posY + radius, entity.posZ + radius);
                List<EntityZombieCreeper> zombles = entity.world.getEntitiesWithinAABB(EntityZombieCreeper.class, bb, creature -> entity != creature);

                if (!zombles.isEmpty()) {
                    if (zombles.size() == 1) {
                        zombles.get(0).addCreeper();
                    } else {
                        // we have more, and determine which is closest
                        float dist = Float.POSITIVE_INFINITY;
                        EntityZombieCreeper closest = null;

                        for (EntityZombieCreeper zomble : zombles) {
                            float newDist = entity.getDistance(zomble);

                            if (newDist < dist) {
                                dist = newDist;
                                closest = zomble;
                            }
                        }

                        if (closest != null) {
                            closest.addCreeper();
                        }
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onEntityHurt(LivingHurtEvent event) {
            Entity entity = event.getEntity();
            DamageSource damage = event.getSource();

            if (entity instanceof EntitySpringCreeper && !entity.world.isRemote && damage == DamageSource.FALL) {
                EntitySpringCreeper creeper = (EntitySpringCreeper) entity;

                if (creeper.isSprung()) {
                    creeper.world.createExplosion(creeper, creeper.posX, creeper.posY - 2.0D, creeper.posZ, creeper.getExplosionPower() * ((event.getAmount() < 6.0F ? 6.0F : event.getAmount()) / 6.0F), creeper.world.getGameRules().getBoolean("mobGriefing"));
                    creeper.setDead();
                }
            }
        }

        @SubscribeEvent
        public static void onPlayerLogIn(PlayerLoggedInEvent event) {
            if (ModConfig.general.checkForUpdates && UpdateChecker.hasUpdate()) {
                event.player.sendMessage(UpdateChecker.getUpdateNotification());
            }
        }
    }

    @EventBusSubscriber(value = Side.CLIENT, modid = ElementalCreepers.MODID)
    public static class ClientLoader {

        private ClientLoader() {}

        @SubscribeEvent
        public static void onModelRegistration(ModelRegistryEvent event) {
            RenderingRegistry.registerEntityRenderingHandler(EntityCreeper.class, RenderAngryCreeper::new);
            registerRenderer(EntityCakeCreeper.class, "cakecreeper");
            registerRenderer(EntityCookieCreeper.class, "cookiecreeper");
            registerRenderer(EntityDarkCreeper.class, "darkcreeper");
            registerRenderer(EntityEarthCreeper.class, "earthcreeper");
            registerRenderer(EntityEnderCreeper.class, "endercreeper");
            registerRenderer(EntityFireCreeper.class, "firecreeper");
            registerRenderer(EntityFireworkCreeper.class, "fireworkcreeper");
            registerRenderer(EntityFurnaceCreeper.class, "furnacecreeper");
            RenderingRegistry.registerEntityRenderingHandler(EntityGhostCreeper.class, manager -> new RenderBaseCreeper(manager, true));
            RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyCreeper.class, RenderFriendlyCreeper::new);
            registerRenderer(EntityBallisticCreeper.class, "hydrogencreeper");
            registerRenderer(EntityIceCreeper.class, "icecreeper");
            registerRenderer(EntityIllusionCreeper.class, "illusioncreeper");
            registerRenderer(EntityLightCreeper.class, "lightcreeper");
            registerRenderer(EntityLightningCreeper.class, "lightningcreeper");
            registerRenderer(EntityMagmaCreeper.class, "magmacreeper");
            registerRenderer(EntityPsychicCreeper.class, "psychiccreeper");
            registerRenderer(EntityReverseCreeper.class, "reversecreeper");
            RenderingRegistry.registerEntityRenderingHandler(EntitySpiderCreeper.class, RenderSpiderCreeper::new);
            registerRenderer(EntitySpringCreeper.class, "springcreeper");
            registerRenderer(EntityStoneCreeper.class, "stonecreeper");
            registerRenderer(EntityWaterCreeper.class, "watercreeper");
            registerRenderer(EntityWindCreeper.class, "windcreeper");
            registerRenderer(EntityZombieCreeper.class, "zombiecreeper");
        }

        private static void registerRenderer(Class<? extends EntityBaseCreeper> creeper, String textureName) {
            RenderingRegistry.registerEntityRenderingHandler(creeper, manager -> new RenderBaseCreeper(manager, textureName));
        }
    }
}
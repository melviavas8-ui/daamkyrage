package ua.daamky.core.manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.daamky.module.api.Module;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.module.ModuleRoles;
import ua.daamky.modules.combat.AntiBot;
import ua.daamky.modules.combat.AntiCrystal;
import ua.daamky.modules.combat.AttackAura;
import ua.daamky.modules.combat.AutoExplosion;
import ua.daamky.modules.combat.AutoGApple;
import ua.daamky.modules.combat.AutoSwap;
import ua.daamky.modules.combat.AutoTotem;
import ua.daamky.modules.combat.Criticals;
import ua.daamky.modules.combat.ElytraTarget;
import ua.daamky.modules.combat.FastBow;
import ua.daamky.modules.combat.HitBox;
import ua.daamky.modules.combat.HitSounds;
import ua.daamky.modules.combat.TargetPearl;
import ua.daamky.modules.combat.TriggerBot;
import ua.daamky.modules.combat.Velocity;
import ua.daamky.modules.misc.AhHelper;
import ua.daamky.modules.misc.AppleFarmer;
import ua.daamky.modules.misc.AutoAccept;
import ua.daamky.modules.misc.AutoAncientBot;
import ua.daamky.modules.misc.AutoAuth;
import ua.daamky.modules.misc.AutoBuy;
import ua.daamky.modules.misc.AutoCraft;
import ua.daamky.modules.misc.AutoDrop;
import ua.daamky.modules.misc.AutoFTCraftMembrana;
import ua.daamky.modules.misc.AutoFTObsidianFarm;
import ua.daamky.modules.misc.AutoLeave;
import ua.daamky.modules.misc.AutoPottBot;
import ua.daamky.modules.misc.AutoResell;
import ua.daamky.modules.misc.AutoSell;
import ua.daamky.modules.misc.AutoVillageTrade;
import ua.daamky.modules.misc.AutoWood;
import ua.daamky.modules.misc.BaseFinder;
import ua.daamky.modules.misc.Cape;
import ua.daamky.modules.misc.ChatHelper;
import ua.daamky.modules.misc.ChorusFarm;
import ua.daamky.modules.misc.ClanUpgrade;
import ua.daamky.modules.misc.ClientUtil;
import ua.daamky.modules.misc.CocoaFarm;
import ua.daamky.modules.misc.CreeperFarm;
import ua.daamky.modules.misc.EmeraldArmorFarm;
import ua.daamky.modules.misc.FreeLock;
import ua.daamky.modules.misc.ItemScroller;
import ua.daamky.modules.misc.LockSlots;
import ua.daamky.modules.misc.MoneyFarm;
import ua.daamky.modules.misc.Party;
import ua.daamky.modules.misc.PotionCombiner;
import ua.daamky.modules.misc.PvPSafe;
import ua.daamky.modules.misc.Removals;
import ua.daamky.modules.misc.Scaffold;
import ua.daamky.modules.misc.SeeInvisibles;
import ua.daamky.modules.misc.ServerDHelper;
import ua.daamky.modules.misc.ServerHelper;
import ua.daamky.modules.misc.ServerJoiner;
import ua.daamky.modules.misc.TapeMouse;
import ua.daamky.modules.misc.TotemVoices;
import ua.daamky.modules.misc.UnHook;
import ua.daamky.modules.misc.UseTracker;
import ua.daamky.modules.misc.WardenFarm;
import ua.daamky.modules.movement.AirStuck;
import ua.daamky.modules.movement.AutoDodge;
import ua.daamky.modules.movement.DragonFly;
import ua.daamky.modules.movement.ElytraMotion;
import ua.daamky.modules.movement.GrimGlide;
import ua.daamky.modules.movement.InvMove;
import ua.daamky.modules.movement.Jesus;
import ua.daamky.modules.movement.NoFall;
import ua.daamky.modules.movement.NoSlow;
import ua.daamky.modules.movement.NoWeb;
import ua.daamky.modules.movement.Speed;
import ua.daamky.modules.movement.Spider;
import ua.daamky.modules.movement.Sprint;
import ua.daamky.modules.movement.Timer;
import ua.daamky.modules.player.ActionRecorder;
import ua.daamky.modules.player.AntiAFK;
import ua.daamky.modules.player.AutoDuel;
import ua.daamky.modules.player.AutoFish;
import ua.daamky.modules.player.AutoInvisible;
import ua.daamky.modules.player.AutoLes;
import ua.daamky.modules.player.AutoPotion;
import ua.daamky.modules.player.AutoTool;
import ua.daamky.modules.player.Blink;
import ua.daamky.modules.player.CameraClip;
import ua.daamky.modules.player.ChestStealer;
import ua.daamky.modules.player.ClickPearl;
import ua.daamky.modules.player.ElytraHelper;
import ua.daamky.modules.player.FakePlayer;
import ua.daamky.modules.player.FastBreak;
import ua.daamky.modules.player.FreeCamera;
import ua.daamky.modules.player.GeyserHelper;
import ua.daamky.modules.player.NoDelay;
import ua.daamky.modules.player.NoInteract;
import ua.daamky.modules.player.NoPush;
import ua.daamky.modules.player.OpenWalls;
import ua.daamky.modules.player.PlayerHelper;
import ua.daamky.modules.player.RotationLab;
import ua.daamky.modules.player.Test;
import ua.daamky.modules.player.WindHop;
import ua.daamky.modules.visuals.AncientXray;
import ua.daamky.modules.visuals.Animations;
import ua.daamky.modules.visuals.Arrows;
import ua.daamky.modules.visuals.AspectRation;
import ua.daamky.modules.visuals.AtmoDawnFog;
import ua.daamky.modules.visuals.AttackEffect;
import ua.daamky.modules.visuals.BlockESP;
import ua.daamky.modules.visuals.BlockOutline;
import ua.daamky.modules.visuals.Chams;
import ua.daamky.modules.visuals.ChinaHat;
import ua.daamky.modules.visuals.ColorPlus;
import ua.daamky.modules.visuals.DeadEffect;
import ua.daamky.modules.visuals.ESP;
import ua.daamky.modules.visuals.FullBright;
import ua.daamky.modules.visuals.GlowESP;
import ua.daamky.modules.visuals.Hands;
import ua.daamky.modules.visuals.Hud;
import ua.daamky.modules.visuals.ItemPhysic;
import ua.daamky.modules.visuals.JumpCircle;
import ua.daamky.modules.visuals.Menu;
import ua.daamky.modules.visuals.MotionBlur;
import ua.daamky.modules.visuals.NameTags;
import ua.daamky.modules.visuals.Particles;
import ua.daamky.modules.visuals.Predictions;
import ua.daamky.modules.visuals.ProtectInfo;
import ua.daamky.modules.visuals.Screens;
import ua.daamky.modules.visuals.Stardust;
import ua.daamky.modules.visuals.SwingAnimation;
import ua.daamky.modules.visuals.TargetESP;
import ua.daamky.modules.visuals.Trails;
import ua.daamky.modules.visuals.VisibleEating;
import ua.daamky.modules.visuals.WorldTweaks;
import ua.daamky.profile.Profile;
import ua.daamky.profile.Role;

public class FeatureManager {
   public final ArrayList<Module> instance = new ArrayList<>();

   public FeatureManager() {
      this.handle();
   }

   public void handle() {
      this.process(new ClientUtil());
      this.process(new Menu());
      this.process(new UnHook());
      this.process(new AntiCrystal());
      this.process(new AutoGApple());
      this.process(new AutoSwap());
      this.process(new AutoExplosion());
      this.process(new AutoTotem());
      this.process(new FastBow());
      this.process(new HitBox());
      this.process(new HitSounds());
      this.process(new ColorPlus());
      this.process(new Velocity());
      this.process(new AhHelper());
      this.process(new AppleFarmer());
      this.process(new Scaffold());
      this.process(new CocoaFarm());
      this.process(new ChorusFarm());
      this.process(new AutoBuy());
      this.process(new AutoDrop());
      this.process(new LockSlots());
      this.process(new AutoLeave());
      this.process(new AutoAncientBot());
      this.process(new AutoFTCraftMembrana());
      this.process(new AutoSell());
      this.process(new AutoResell());
      this.process(new BaseFinder());
      this.process(new FreeLock());
      this.process(new ua.daamky.modules.misc.FriendManager());
      this.process(new ItemScroller());
      this.process(new Removals());
      this.process(new SeeInvisibles());
      this.process(new ServerDHelper());
      this.process(new ServerJoiner());
      this.process(new ServerHelper());
      this.process(new TotemVoices());
      this.process(new UseTracker());
      this.process(new AutoDodge());
      this.process(new DragonFly());
      this.process(new GrimGlide());
      this.process(new InvMove());
      this.process(new NoFall());
      this.process(new NoSlow());
      this.process(new NoWeb());
      this.process(new Speed());
      this.process(new Spider());
      this.process(new Sprint());
      this.process(new Timer());
      this.process(new AntiAFK());
      this.process(new ActionRecorder());
      this.process(new RotationLab());
      this.process(new AutoFish());
      this.process(new ChestStealer());
      this.process(new AutoTool());
      this.process(new FakePlayer());
      this.process(new CameraClip());
      this.process(new ElytraHelper());
      this.process(new FreeCamera());
      this.process(new ClickPearl());
      this.process(new NoDelay());
      this.process(new NoInteract());
      this.process(new NoPush());
      this.process(new OpenWalls());
      this.process(new PlayerHelper());
      this.process(new WindHop());
      this.process(new Blink());
      this.process(new AncientXray());
      this.process(new Animations());
      this.process(new AttackEffect());
      this.process(new Arrows());
      this.process(new AspectRation());
      this.process(new BlockOutline());
      this.process(new BlockESP());
      this.process(new WorldTweaks());
      this.process(new MotionBlur());
      this.process(new Chams());
      this.process(new ESP());
      this.process(new GlowESP());
      this.process(new Hands());
      this.process(new ChinaHat());
      this.process(new Hud());
      this.process(new ItemPhysic());
      this.process(new JumpCircle());
      this.process(new AtmoDawnFog());
      this.process(new DeadEffect());
      this.process(new NameTags());
      this.process(new FullBright());
      this.process(new Particles());
      this.process(new Predictions());
      this.process(new ProtectInfo());
      this.process(new PvPSafe());
      this.process(new SwingAnimation());
      this.process(new Stardust());
      this.process(new TargetESP());
      this.process(new VisibleEating());
      this.process(new Jesus());
      this.process(new ElytraMotion());
      this.process(new ChatHelper());
      this.process(new CreeperFarm());
      this.process(new TapeMouse());
      this.process(new AutoCraft());
      this.process(new AttackAura());
      this.process(new TriggerBot());
      this.process(new Criticals());
      this.process(new ElytraTarget());
      this.process(new TargetPearl());
      this.process(new AntiBot());
      this.process(new AutoPotion());
      this.process(new AutoInvisible());
      this.process(new AutoDuel());
      this.process(new AirStuck());
      this.process(new FastBreak());
      this.process(new AutoLes());
      this.process(new Trails());
      this.process(new Screens());
      this.process(new AutoAccept());
      this.process(new GeyserHelper());
      this.process(new Test());
      this.process(new AutoAuth());
      this.process(new PotionCombiner());
      this.process(new MoneyFarm());
      this.process(new EmeraldArmorFarm());
      this.process(new AutoVillageTrade());
      this.process(new ClanUpgrade());
      this.process(new Party());
      this.process(new Cape());
      this.process(new AutoPottBot());
      this.process(new WardenFarm());
      this.process(new AutoWood());
      this.process(new AutoFTObsidianFarm());
      this.instance.sort(Comparator.comparing(module -> module.getSearchName().toLowerCase()));
      System.out.println("[Manager] register " + this.instance.size() + " modules.");
   }

   private void process(Module var1) {
      if (var1 != null) {
         this.instance.add(var1);
      }
   }

   public ArrayList<Module> process() {
      return this.instance.stream().filter(this::handle).collect(Collectors.toCollection(ArrayList::new));
   }

   public <T extends Module> T handle(Class<T> var1) {
      for (Module var3 : this.instance) {
         if (var3.getClass() == var1) {
            return (T)var3;
         }
      }

      return null;
   }

   public Module process(Class<?> var1) {
      for (Module var3 : this.instance) {
         if (var3.getClass() == var1) {
            return var3;
         }
      }

      return null;
   }

   public ArrayList<Module> handle(ModuleCategory var1) {
      return this.instance.stream().filter(this::handle).filter(var1x -> var1x.category == var1).collect(Collectors.toCollection(ArrayList::new));
   }

   public Module[] handle(int var1) {
      return this.instance.stream().filter(this::handle).filter(var1x -> var1x.keyCode == var1).toArray(Module[]::new);
   }

   public boolean handle(Module var1) {
      return var1 != null && handle(var1.getRoles());
   }

   public boolean compute(Class<? extends Module> var1) {
      return var1 == null ? false : handle(var1.getAnnotation(ModuleRoles.class));
   }

   public static boolean handle(ModuleRoles var0) {
      if (var0 == null) {
         return true;
      } else {
         boolean var1 = var0.handle() != Role.DEFAULT || var0.process().length > 0 || var0.compute().length > 0 || var0.resolve().length > 0;
         if (!var1) {
            return true;
         } else if (Profile.isUid(var0.resolve())) {
            return true;
         } else if (Profile.isUsername(var0.compute())) {
            return true;
         } else {
            return Profile.hasRole(var0.process()) ? true : var0.handle() != Role.DEFAULT && Profile.hasRoleAtLeast(var0.handle());
         }
      }
   }
}

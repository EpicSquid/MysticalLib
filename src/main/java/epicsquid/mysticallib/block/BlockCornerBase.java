package epicsquid.mysticallib.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.shapes.VoxelShape;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class BlockCornerBase extends BlockBase {
  public static Map<Integer, List<VoxelShape>> boxes = new HashMap<>();

  public static final BooleanProperty UP = BooleanProperty.create("up");
  public static final IntegerProperty DIR = IntegerProperty.create("dir", 0, 3); //NXNZ -> PXNZ -> PXPZ -> NXPZ corner
  public static final BooleanProperty INNER = BooleanProperty.create("inner");

  public boolean inner = false;
//  protected @Nullable BlockState parent = null;


  public BlockCornerBase(@Nonnull Material mat, @Nonnull SoundType type, float hardness, @Nonnull String name) {
    super(mat, type, hardness, name);
  }

//  public BlockCornerBase(@Nonnull BlockState parent, @Nonnull SoundType type, float hardness, @Nonnull String name, boolean inner) {
//    this(parent.getMaterial(), type, hardness, name, inner);
//    this.parent = parent;
//  }
//
//  @Override
//  @Nonnull
//  public BlockStateContainer createBlockState() {
//    return new BlockStateContainer(this, INNER, UP, DIR);
//  }
//
//  @Override
//  @Nonnull
//  public BlockState getStateFromMeta(int meta) {
//    return getDefaultState().withProperty(INNER, inner).withProperty(UP, (int) (meta / 4) > 0).withProperty(DIR, meta % 4);
//  }
//
//  @Override
//  public int getMetaFromState(@Nonnull BlockState state) {
//    return (state.getValue(UP) ? 1 : 0) * 4 + state.getValue(DIR);
//  }
//
//  @Override
//  @Nonnull
//  public BlockState withRotation(@Nonnull BlockState state, @Nonnull Rotation rot) {
//    int newDir = (state.getValue(DIR) + rot.ordinal()) % 4;
//    return state.withProperty(DIR, newDir);
//  }
//
//  @Override
//  public void addCollisionBoxToList(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull AxisAlignedBB entityBox,
//      @Nonnull List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean advanced) {
//    float box_precision = BlockSlantBase.box_precision;
//    List<AxisAlignedBB> temp = new ArrayList<>();
//    boolean up = state.getValue(UP);
//    int dir = state.getValue(DIR);
//    if (inner) {
//      if (!up) {
//        switch (dir) {
//        case 0:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, i, 1.0, i + box_precision, 1.0));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(i, i, 0, 1.0, i + box_precision, 1.0));
//          }
//          break;
//        case 1:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, i, 1.0, i + box_precision, 1.0));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, 0, 1.0 - i, i + box_precision, 1.0));
//          }
//          break;
//        case 2:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, 0, 1.0, i + box_precision, 1.0 - i));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, 0, 1.0 - i, i + box_precision, 1.0));
//          }
//          break;
//        case 3:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, 0, 1.0, i + box_precision, 1.0 - i));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(i, i, 0, 1.0, i + box_precision, 1.0));
//          }
//          break;
//        }
//      } else {
//        switch (dir) {
//        case 0:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, i, 1.0, (1.0 - box_precision) - i, 1.0));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(i, 1.0 - i, 0, 1.0, (1.0 - box_precision) - i, 1.0));
//          }
//          break;
//        case 1:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, i, 1.0, (1.0 - box_precision) - i, 1.0));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, 0, 1.0 - i, (1.0 - box_precision) - i, 1.0));
//          }
//          break;
//        case 2:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, 0, 1.0, (1.0 - box_precision) - i, 1.0 - i));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, 0, 1.0 - i, (1.0 - box_precision) - i, 1.0));
//          }
//          break;
//        case 3:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, 0, 1.0, (1.0 - box_precision) - i, 1.0 - i));
//          }
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(i, 1.0 - i, 0, 1.0, (1.0 - box_precision) - i, 1.0));
//          }
//          break;
//        }
//      }
//    } else {
//      if (!up) {
//        switch (dir) {
//        case 0:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, 0, 1.0 - i, i + box_precision, 1.0 - i));
//          }
//          break;
//        case 1:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(1.0, i, 0, i, i + box_precision, 1.0 - i));
//          }
//          break;
//        case 2:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(1.0, i, 1.0, i, i + box_precision, i));
//          }
//          break;
//        case 3:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, i, 1.0, 1.0 - i, i + box_precision, i));
//          }
//          break;
//        }
//      } else {
//        switch (dir) {
//        case 0:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, 0, 1.0 - i, (1.0 - i) - box_precision, 1.0 - i));
//          }
//          break;
//        case 1:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(1.0, 1.0 - i, 0, i, (1.0 - i) - box_precision, 1.0 - i));
//          }
//          break;
//        case 2:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(1.0, 1.0 - i, 1.0, i, (1.0 - i) - box_precision, i));
//          }
//          break;
//        case 3:
//          for (float i = 0; i < 1; i += box_precision) {
//            temp.add(new AxisAlignedBB(0, 1.0 - i, 1.0, 1.0 - i, (1.0 - i) - box_precision, i));
//          }
//          break;
//        }
//      }
//    }
//    for (AxisAlignedBB b : temp) {
//      addCollisionBoxToList(pos, entityBox, collidingBoxes, b);
//    }
//  }
//
//  @Override
//  @Nonnull
//  public BlockState getStateForPlacement(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing face, float hitX, float hitY, float hitZ, int meta,
//      @Nonnull EntityLivingBase placer) {
//    boolean up = (hitY > 0.5f);
//    if (hitY == 1) {
//      up = false;
//    }
//    if (hitY == 0) {
//      up = true;
//    }
//    int dir = 0;
//    if (hitX > 0 && hitX < 1 && hitZ > 0 && hitZ < 1) {
//      if (hitX < 0.5 && hitZ < 0.5) {
//        dir = 0;
//      }
//      if (hitX >= 0.5 && hitZ < 0.5) {
//        dir = 1;
//      }
//      if (hitX >= 0.5 && hitZ >= 0.5) {
//        dir = 2;
//      }
//      if (hitX < 0.5 && hitZ >= 0.5) {
//        dir = 3;
//      }
//    }
//    if (hitX == 0) {
//      if (hitZ < 0.5) {
//        dir = 1;
//      }
//      if (hitZ >= 0.5) {
//        dir = 2;
//      }
//    }
//    if (hitZ == 0) {
//      if (hitX < 0.5) {
//        dir = 3;
//      }
//      if (hitX >= 0.5) {
//        dir = 2;
//      }
//    }
//    if (hitX == 1) {
//      if (hitZ < 0.5) {
//        dir = 0;
//      }
//      if (hitZ >= 0.5) {
//        dir = 3;
//      }
//    }
//    if (hitZ == 1) {
//      if (hitX < 0.5) {
//        dir = 0;
//      }
//      if (hitX > 0.5) {
//        dir = 1;
//      }
//    }
//    return getDefaultState().withProperty(UP, up).withProperty(DIR, dir);
//  }
//
//  @Override
//  public boolean shouldSideBeRendered(@Nonnull BlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
//    return true;
//  }
//
//  @Override
//  public boolean doesSideBlockRendering(@Nonnull BlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
//    return false;
//  }
//
//  // TODO: Look for a better way of doing this
//  @Override
//  @SideOnly(Side.CLIENT)
//  public void initCustomModel() {
//    if (hasCustomModel()) {
//      ResourceLocation defaultTex = new ResourceLocation(getRegistryName().getNamespace() + ":blocks/" + getRegistryName().getPath());
//      if (parent != null) {
//        defaultTex = new ResourceLocation(parent.getBlock().getRegistryName().getNamespace() + ":blocks/" + parent.getBlock().getRegistryName().getPath());
//      }
//      if (inner) {
//        CustomModelLoader.blockmodels.put(new ResourceLocation(getRegistryName().getNamespace() + ":models/block/" + name),
//            new CustomModelBlock(getModelClass(0), defaultTex, defaultTex));
//        CustomModelLoader.itemmodels.put(new ResourceLocation(getRegistryName().getNamespace() + ":" + name + "#handlers"),
//            new CustomModelBlock(getModelClass(0), defaultTex, defaultTex));
//      } else {
//        CustomModelLoader.blockmodels.put(new ResourceLocation(getRegistryName().getNamespace() + ":models/block/" + name),
//            new CustomModelBlock(getModelClass(1), defaultTex, defaultTex));
//        CustomModelLoader.itemmodels.put(new ResourceLocation(getRegistryName().getNamespace() + ":" + name + "#handlers"),
//            new CustomModelBlock(getModelClass(1), defaultTex, defaultTex));
//      }
//    }
//  }
//
//  @Nonnull
//  @Override
//  protected Class<? extends BakedModelBlock> getModelClass(int type) {
//    if (type == 1) {
//      return BakedModelOuterCorner.class;
//    } else {
//      return BakedModelInnerCorner.class;
//    }
//  }
}

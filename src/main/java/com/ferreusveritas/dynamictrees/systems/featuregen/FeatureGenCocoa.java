package com.ferreusveritas.dynamictrees.systems.featuregen;

import java.util.List;

import com.ferreusveritas.dynamictrees.api.IPostGenFeature;
import com.ferreusveritas.dynamictrees.api.IPostGrowFeature;
import com.ferreusveritas.dynamictrees.api.TreeHelper;
import com.ferreusveritas.dynamictrees.api.network.MapSignal;
import com.ferreusveritas.dynamictrees.systems.nodemappers.NodeFruitCocoa;
import com.ferreusveritas.dynamictrees.util.SafeChunkBounds;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class FeatureGenCocoa implements IPostGenFeature, IPostGrowFeature {
	
	@Override
	public boolean postGrow(World world, BlockPos rootPos, BlockPos treePos, int soilLife, boolean natural) {
		if(soilLife == 0 && world.rand.nextInt() % 16 == 0) {
			addCocoa(world, rootPos, false);
		}
		return false;
	}
	
	@Override
	public boolean postGeneration(World world, BlockPos rootPos, Biome biome, int radius, List<BlockPos> endPoints, SafeChunkBounds safeBounds, IBlockState initialDirtState) {
		if(world.rand.nextInt() % 8 == 0) {
			addCocoa(world, rootPos, true);
			return true;
		}
		return false;
	}
	
	private void addCocoa(World world, BlockPos rootPos, boolean worldGen) {
		TreeHelper.startAnalysisFromRoot(world, rootPos, new MapSignal(new NodeFruitCocoa().setWorldGen(worldGen)));
	}
	
}

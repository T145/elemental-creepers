package T145.elementalcreepers.client.render.model;

import T145.elementalcreepers.api.client.IModelCreeper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSpiderCreeper extends ModelBase implements IModelCreeper {

	public ModelRenderer head;
	public ModelRenderer creeperArmor;
	public ModelRenderer body;
	public ModelRenderer leg1;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	public ModelRenderer leg5;
	public ModelRenderer leg6;

	public ModelSpiderCreeper() {
		this(0.0F);
	}

	public ModelSpiderCreeper(float offset) {
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, offset);
		this.head.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.creeperArmor = new ModelRenderer(this, 32, 0);
		this.creeperArmor.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, offset + 0.5F);
		this.creeperArmor.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.body = new ModelRenderer(this, 16, 16);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, offset);
		this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 16);
		this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, offset);
		this.leg1.setRotationPoint(-2.0F, 18.0F, 4.0F);
		this.leg2 = new ModelRenderer(this, 0, 16);
		this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, offset);
		this.leg2.setRotationPoint(2.0F, 18.0F, 4.0F);
		this.leg3 = new ModelRenderer(this, 0, 16);
		this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, offset);
		this.leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
		this.leg4 = new ModelRenderer(this, 0, 16);
		this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, offset);
		this.leg4.setRotationPoint(2.0F, 18.0F, -4.0F);
		this.leg5 = new ModelRenderer(this, 0, 16);
		this.leg5.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg5.setRotationPoint(-6.0F, 18F, 0.0F);
		this.leg6 = new ModelRenderer(this, 0, 16);
		this.leg6.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg6.setRotationPoint(6.0F, 18F, 0.0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
		this.body.render(scale);
		this.leg1.render(scale);
		this.leg2.render(scale);
		this.leg3.render(scale);
		this.leg4.render(scale);
		this.leg5.render(scale);
		this.leg6.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void postRenderHead() {
		head.postRender(HEAD_OFFSET);
	}
}
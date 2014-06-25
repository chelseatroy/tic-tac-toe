class RecipesController < ApplicationController

  def index
    @title = "Recipes"
    @recipes = Recipe.all
  end

  def show
    @recipe = Recipe.find(params[:id]) 
  end

  def new
    @recipe = Recipe.new
  end

  def create
    Recipe.create(params[:recipe])
  end

  def edit
    @recipe = Recipe.find(params[:id])
  end

  def update
    @recipe = Recipe.find(params[:id])
    @recipe.update(params[:recipe])
  end 

  def destroy
    @recipe = Recipe.find(params[:id])
    @recipe.destroy
  end

end

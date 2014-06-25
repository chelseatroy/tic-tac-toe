class ChangeRecipesDirectionsAndIngredientsToText < ActiveRecord::Migration
  def change
    change_table :recipes do |t|
      t.remove :directions, :ingredients
      t.text :directions
      t.text :ingredients
    end
  end
end


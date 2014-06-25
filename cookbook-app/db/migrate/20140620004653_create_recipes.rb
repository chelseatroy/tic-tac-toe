class CreateRecipes < ActiveRecord::Migration
  def change
    create_table :recipes do |t|
      t.string :title
      t.string :author
      t.string :ingredients
      t.string :directions
      t.string :photo
      t.string :prep_time

      t.timestamps
    end
  end
end

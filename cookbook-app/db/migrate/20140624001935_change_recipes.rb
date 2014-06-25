class ChangeRecipes < ActiveRecord::Migration
  def change
    change_table :recipes do |t|
      t.rename :photo, :photo_url
    end
  end
end

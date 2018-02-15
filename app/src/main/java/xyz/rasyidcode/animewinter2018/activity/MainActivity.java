package xyz.rasyidcode.animewinter2018.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import xyz.rasyidcode.animewinter2018.R;
import xyz.rasyidcode.animewinter2018.adapter.AnimeWinterAdapter;
import xyz.rasyidcode.animewinter2018.model.AnimeWinter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimeWinterAdapter adapter;
    private List<AnimeWinter> animeWinterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);

        initCollapsingToolbar();

        recyclerView = findViewById(R.id.rcvw);

        animeWinterList = new ArrayList<>();
        adapter = new AnimeWinterAdapter(this, animeWinterList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAnimeWinter();

        try {
            Log.d("checking_image", "This is correct");
            Glide.with(this).load(R.drawable.cover2).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            Log.d("checking_image", "This is incorrect");
            e.printStackTrace();
        }
    }

    private void prepareAnimeWinter() {
        int[] cover = new int[] {
                R.drawable.sainojoshikousei5a14436327201p,
                R.drawable.basiliskoukaninpouchou59ecc56653959p,
                R.drawable.cardcaptorsakuraclearcardhen5a1911d40992fp,
                R.drawable.citrus5a6c7a050c5b6p,
                R.drawable.dagashikashi25a24ed675c47bp,
                R.drawable.damexprinceanimecaravan5a069af8dd9d0p,
                R.drawable.deathmarchkarahajimaruisekaikyousoukyoku5a02b9ebd49b7p, //6
                R.drawable.fateextralastencore5a49066f2ebecp,
                R.drawable.gakuenbabysitters59f0423bae0dfp,
                R.drawable.ginnoguardianseason25a22a6c6b6ea1p,
                R.drawable.grancrestsenki5a43266a09631p,
                R.drawable.hakatatonkotsuramens5a2112161d096p,
                R.drawable.hakumeitomikochi5a7ee4e08c233p,
                R.drawable.hitorinoshitatheoutcast2ndseason59f2dbe75a762p,
                R.drawable.houshinengi59f9aeaae82d5p,
                R.drawable.idolish75a321e5fa0c1fp,
                R.drawable.itojunjicollection5a02898dccfd0p,
                R.drawable.gintamashiroganenotamashiihen5a45ac0a53594p,
                R.drawable.darlinginthefrankxx5a0d1068cd7ffp,
                R.drawable.beatless5a38faa3f2164p
        };

        AnimeWinter aw = new AnimeWinter("25-Sai no Joshikousei", 0, cover[0]); animeWinterList.add(aw);
        aw = new AnimeWinter("Basilisk: Ouka Ninpouchou", 24, cover[1]); animeWinterList.add(aw);
        aw = new AnimeWinter("Beatless", 24, cover[19]); animeWinterList.add(aw);
        aw = new AnimeWinter("Cardcaptor Sakura: Clear Card-hen", 22, cover[2]); animeWinterList.add(aw);
        aw = new AnimeWinter("Citrus", 12, cover[3]); animeWinterList.add(aw);
        aw = new AnimeWinter("Dagashi Kashi 2", 12, cover[4]); animeWinterList.add(aw);
        aw = new AnimeWinter("Dame x Prince Anime Caravan", 12, cover[5]); animeWinterList.add(aw);
        aw = new AnimeWinter("Darling in the FranXX", 24, cover[18]); animeWinterList.add(aw);
        aw = new AnimeWinter("Death March kara Hajimaru Isekai Kyousoukyoku", 12, cover[6]); animeWinterList.add(aw);
        aw = new AnimeWinter("Fate/Extra Last Encore", 0, cover[7]); animeWinterList.add(aw);
        aw = new AnimeWinter("Gakuen Babysitters", 12, cover[8]); animeWinterList.add(aw);
        aw = new AnimeWinter("Gin no Guardian Season 2", 0, cover[9]); animeWinterList.add(aw);
        aw = new AnimeWinter("Gintama.: Shirogane no Tamashii-hen", 0, cover[17]); animeWinterList.add(aw);
        aw = new AnimeWinter("Grancrest Senki", 24, cover[10]); animeWinterList.add(aw);
        aw = new AnimeWinter("Hakata Tonkotsu Ramens", 0, cover[11]); animeWinterList.add(aw);
        aw = new AnimeWinter("Hakumei to Mikochi", 12, cover[12]); animeWinterList.add(aw);
        aw = new AnimeWinter("Hakyuu Houshin Engi", 23, cover[14]); animeWinterList.add(aw);
        aw = new AnimeWinter("Hitori no Shita: The Outcast 2nd Season", 0, cover[13]); animeWinterList.add(aw);
        aw = new AnimeWinter("IDOLiSH7", 17, cover[15]); animeWinterList.add(aw);
        aw = new AnimeWinter("Ito Junji: Collection", 12, cover[16]); animeWinterList.add(aw);

        adapter.notifyDataSetChanged();
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    Log.d("checking_appbar", "go to ishowtrue");
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    Log.d("checking_appbar", "go to ishowfalse");
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int i, int dpToPx, boolean b) {
            this.spanCount = i;
            this.spacing = dpToPx;
            this.includeEdge = b;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
